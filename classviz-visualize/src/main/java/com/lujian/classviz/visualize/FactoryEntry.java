package com.lujian.classviz.visualize;

import com.lujian.classviz.visualize.classmeta.DigraphNodeAbstractClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeConcreteClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeEnum;
import com.lujian.classviz.visualize.classmeta.DigraphNodeInterface;
import com.lujian.classviz.visualize.meta.Digraph;
import com.lujian.classviz.visualize.meta.DigraphEdge;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import static com.lujian.classviz.visualize.DigraphNodeFactory.*;

public class FactoryEntry {

    public static void main(String[] args) {
        Digraph digraph = DigraphFactory.useDefault();

        DigraphNodeInterface di = createInterface("interface");
        DigraphNodeAbstractClass da = createAbstractClass("abstract class");
        DigraphNodeConcreteClass dc = createConcreteClass("concrete class");
        DigraphNodeEnum de = createEnum("enum");

        digraph.addNode(di);
        digraph.addNode(da);
        digraph.addNode(dc);
        digraph.addNode(de);

        DigraphEdge edge1 = new DigraphEdge();
        edge1.setSource(dc);
        edge1.addTarget(da);

        DigraphEdge edge2 = new DigraphEdge();
        edge2.setSource(dc);
        edge2.addTarget(di);

        digraph.addEdge(edge1);
        digraph.addEdge(edge2);

        Graphviz graph = GraphvizFactory.create(digraph);
        System.out.println(graph.render(Format.SVG).toString());
    }

}
