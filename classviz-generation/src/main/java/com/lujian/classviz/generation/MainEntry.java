package com.lujian.classviz.generation;

import guru.nidi.graphviz.engine.Format;

import java.io.File;
import java.io.IOException;

public class MainEntry {

    public static void main(String[] args) throws IOException {
        Classviz classviz = ClassvizGeneration.scan("E:\\frameworks\\java\\open-jdk\\openjdk\\jdk\\src\\share\\classes\\java\\util\\concurrent");
        classviz.setFormat(Format.SVG);
        classviz.exportToFile(new File("C:\\Users\\LuJian\\Desktop\\1.svg"));
    }

}
