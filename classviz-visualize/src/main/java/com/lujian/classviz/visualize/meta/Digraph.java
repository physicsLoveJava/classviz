package com.lujian.classviz.visualize.meta;

import guru.nidi.graphviz.attribute.RankDir;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class Digraph {

    String name;
    String bgColor;
    String pad;
    Double dpi;
    RankDir rankDir;

    NodeDesc nodeDesc;
    EdgeDesc edgeDEsc;

    Set<DigraphNode> nodeSet = new HashSet<>();
    Set<DigraphEdge> edgeSet = new HashSet<>();

    public void addNode(DigraphNode node) {
        nodeSet.add(node);
    }

    public void addEdge(DigraphEdge edge) {
        edgeSet.add(edge);
    }
}
