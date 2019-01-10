package com.lujian.classviz.generation;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Classviz {

    private Graphviz graph;
    private Format format;

    public Classviz(Graphviz graph) {
        this.graph = graph;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String exportToString() {
        checkFormat();
        return this.graph.render(this.format).toString();
    }

    public void exportToFile(File file) throws IOException {
        checkFormat();
        this.graph.render(this.format).toFile(file);
    }

    public void exportToOutputStream(OutputStream outputStream) throws IOException {
        checkFormat();
        this.graph.render(this.format).toOutputStream(outputStream);
    }

    private void checkFormat() {
        if(this.format == null) {
            throw new IllegalStateException("set output format!");
        }
    }
}
