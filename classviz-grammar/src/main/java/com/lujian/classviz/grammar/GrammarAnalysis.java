package com.lujian.classviz.grammar;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class GrammarAnalysis {

    public static AnalysisUnit parse(CompilationUnit unit) {
        AnalysisUnit result = new AnalysisUnit();
        List<Node> nodeList = unit.getChildNodes();
        for (Node node : nodeList) {
            if (node instanceof PackageDeclaration) {
                result.setPackageDeclaration(((PackageDeclaration) node).getNameAsString());
            }
            if (node instanceof ClassOrInterfaceDeclaration) {
                NodeList<ClassOrInterfaceType> extendedTypes = ((ClassOrInterfaceDeclaration) node).getExtendedTypes();
                if(extendedTypes != null && !extendedTypes.isEmpty()) {
                    result.setExtendedType(extendedTypes.get(0).asString());
                }
                NodeList<ClassOrInterfaceType> implementedTypes = ((ClassOrInterfaceDeclaration) node).getImplementedTypes();
                if(implementedTypes != null && !implementedTypes.isEmpty()) {
                    List<String> implementList = new ArrayList<>(implementedTypes.size());
                    for (ClassOrInterfaceType type : implementedTypes) {
                        implementList.add(type.getNameAsString());
                    }
                    result.setImplementedTypeList(implementList);
                }

                //class name
                result.setClassName(((ClassOrInterfaceDeclaration) node).getNameAsString());
                //class type
                if(((ClassOrInterfaceDeclaration) node).isInterface()) {
                    result.setClassType(ClassTypeEnum.T_INTERFACE);
                }else {
                    if (((ClassOrInterfaceDeclaration) node).getModifiers().contains(Modifier.abstractModifier())) {
                        result.setClassType(ClassTypeEnum.T_ABSTRACT);
                    }else {
                        result.setClassType(ClassTypeEnum.T_CLASS);
                    }
                }
            }
            if(node instanceof EnumDeclaration) {
                result.setClassName(((EnumDeclaration) node).getNameAsString());
                result.setClassType(ClassTypeEnum.T_ENUM);
            }
        }
        return result;
    }

    public static AnalysisUnit parse(String code) {
        return parse(JavaParser.parse(code));
    }

    public static List<AnalysisUnit> parsePath(Path path) throws IOException {
        return parseFile(path.toFile());
    }

    public static List<AnalysisUnit> parseFile(File file) throws IOException {
        List<AnalysisUnit> resultList = new ArrayList<>();
        if(!file.isDirectory()) {
            String filename = file.getName();
            int idx = filename.lastIndexOf(".");
            if(idx != -1 && filename.substring(idx).equals(".java")) {
                resultList.add(parse(JavaParser.parse(file)));
            }
            return resultList;
        }
        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                String filename = path.getFileName().toString();
                int idx = filename.lastIndexOf(".");
                if(idx != -1 && filename.substring(idx).equals(".java")) {
                    resultList.add(parse(JavaParser.parse(path)));
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(GrammarAnalysis.parse("package com.lujian.classviz.grammar.demo;\n" +
                "\n" +
                "public enum AEnum {\n" +
                "}\n"));
        System.out.println(GrammarAnalysis.parse("package com.lujian.classviz.grammar.demo;\n" +
                "\n" +
                "public abstract class AConcreteClass extends AAbstractClass implements AInterface, BInterface{\n" +
                "}\n"));

        try {
            System.out.println(GrammarAnalysis.parseFile(new File("E:\\codes\\java\\idea-tify\\classviz\\classviz-visualize\\src\\main\\java\\com\\lujian\\classviz\\visualize\\classmeta")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
