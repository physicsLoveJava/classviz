package com.lujian.classviz.generation;

import com.lujian.classviz.grammar.AnalysisUnit;
import com.lujian.classviz.grammar.GrammarAnalysis;
import com.lujian.classviz.visualize.DigraphFactory;
import com.lujian.classviz.visualize.GraphvizFactory;
import com.lujian.classviz.visualize.classmeta.DigraphNodeAbstractClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeConcreteClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeEnum;
import com.lujian.classviz.visualize.classmeta.DigraphNodeInterface;
import com.lujian.classviz.visualize.meta.Digraph;
import com.lujian.classviz.visualize.meta.DigraphEdge;
import com.lujian.classviz.visualize.meta.DigraphNode;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassvizGeneration {

    public static Classviz scan(List<String> pathList) throws IOException{
        List<AnalysisUnit> totalUnitList = new ArrayList<>();
        for (String path : pathList) {
            totalUnitList.addAll(GrammarAnalysis.parseFile(new File(path)));
        }
        Digraph digraph = DigraphFactory.useDefault();
        transformToDigraph(totalUnitList, digraph);
        Graphviz graph = GraphvizFactory.create(digraph);
        return new Classviz(graph);
    }

    public static Classviz scan(String... paths) throws IOException{
        return scan(Arrays.asList(paths));
    }

    public static Classviz scan(String path) throws IOException {
        return scan(Arrays.asList(path));
    }

    private static void transformToDigraph(List<AnalysisUnit> unitList, Digraph digraph) {
        unitList.forEach(analysisUnit -> {
            if(analysisUnit == null || analysisUnit.getClassName() == null) {
                return;
            }
            DigraphNode node = null;
            switch (analysisUnit.getClassType()) {
                case T_CLASS:
                    node = new DigraphNodeConcreteClass(analysisUnit.getClassName());
                    break;
                case T_ABSTRACT:
                    node = new DigraphNodeAbstractClass(analysisUnit.getClassName());
                    break;
                case T_INTERFACE:
                    node = new DigraphNodeInterface(analysisUnit.getClassName());
                    break;
                case T_ENUM:
                    node = new DigraphNodeEnum(analysisUnit.getClassName());
                    break;
            }
            if (analysisUnit.getExtendedType() == null
                    && (analysisUnit.getImplementedTypeList() == null
                    || analysisUnit.getImplementedTypeList().isEmpty())) {
                digraph.addNode(node);
            }else {
                digraph.addNode(node);
                if(analysisUnit.getExtendedType() != null) {
                    DigraphEdge edge = new DigraphEdge();
                    edge.setSource(node);
                    edge.addTarget(new DigraphNodeConcreteClass(analysisUnit.getExtendedType()));
                    digraph.addEdge(edge);
                }
                if (analysisUnit.getImplementedTypeList() != null && !analysisUnit.getImplementedTypeList().isEmpty()) {
                    for (String implementType : analysisUnit.getImplementedTypeList()) {
                        DigraphEdge edge = new DigraphEdge();
                        edge.setSource(node);
                        edge.addTarget(new DigraphNodeInterface(implementType));
                        digraph.addEdge(edge);
                    }
                }
            }
        });
    }

}
