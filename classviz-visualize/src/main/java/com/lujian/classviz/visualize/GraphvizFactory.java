package com.lujian.classviz.visualize;

import com.lujian.classviz.visualize.meta.*;
import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static guru.nidi.graphviz.model.Factory.*;

public class GraphvizFactory {

    public static Graphviz create(Digraph digraph) {
        MutableGraph g = mutGraph("sampleDigraph").setDirected(true).use((gr, ctx) -> {
            applyGraphDesc(graphAttrs(), digraph);
            applyNodeDesc(nodeAttrs(), digraph.getNodeDesc());
            createDefNode(digraph.getNodeSet());
            createEdge(digraph.getEdgeSet());
        });
        return Graphviz.fromGraph(g);
    }

    private static void applyGraphDesc(MutableAttributed<?, ForGraph> attrs, Digraph digraph) {
        if(!StringUtils.isBlank(digraph.getName())) {
            attrs.add("name", digraph.getName());
        }
        if(!StringUtils.isBlank(digraph.getBgColor())) {
            attrs.add("bgcolor", digraph.getBgColor());
        }
        if(!StringUtils.isBlank(digraph.getPad())) {
            attrs.add("pad", digraph.getPad());
        }
        if(digraph.getRankDir() != null) {
            attrs.add(digraph.getRankDir());
        }
        if(digraph.getDpi() != null) {
            attrs.add("dpi", digraph.getDpi());
        }
    }

    private static void applyNodeDesc(MutableAttributed<?, ForNode> attrs, NodeDesc desc) {
        if(desc.getShape() != null) {
            attrs.add(desc.getShape());
        }
        if(desc.getStyle() != null) {
            attrs.add(desc.getStyle());
        }
        if(!StringUtils.isBlank(desc.getFillColor())) {
            attrs.add(Color.rgb(desc.getFillColor()).fill());
        }
        if(!StringUtils.isBlank(desc.getColor())) {
            attrs.add(Color.rgb(desc.getColor()));
        }
        if(!StringUtils.isBlank(desc.getFontSize())) {
            attrs.add("fontsize", desc.getFontSize());
        }
        if(!StringUtils.isBlank(desc.getWidth())) {
            attrs.add("width", desc.getWidth());
        }
        if(!StringUtils.isBlank(desc.getHeight())) {
            attrs.add("height", desc.getHeight());
        }
        if(!StringUtils.isBlank(desc.getFont())) {
            attrs.add("font", desc.getFont());
        }
        if(!StringUtils.isBlank(desc.getPenWidth())) {
            attrs.add("penwidth", desc.getPenWidth());
        }
        if(!StringUtils.isBlank(desc.getLabel())) {
            attrs.add(Label.of(desc.getLabel()));
        }
    }

    private static LinkSource[] createEdge(Set<DigraphEdge> edgeSet) {
        if(edgeSet == null) {
            return new LinkSource[0];
        }
        Set<LinkSource> set = new HashSet<>();
        for (DigraphEdge edge : edgeSet) {
            List<DigraphNode> targetList = edge.getTargetList();
            MutableNode node = createNode(edge.getSource());
            for (DigraphNode target : targetList) {
                Link link = node.linkTo(createNode(target));
                link.add(target.getEdgeStyle());
                link.add(target.getEdgeArrow());
                link.add(Color.rgb(ColorEnum.WHITE.getCode()));
                node.addLink(link);
            }
            set.add(node);
        }
        return set.toArray(new LinkSource[0]);
    }

    private static MutableNode createNode(DigraphNode node) {
        MutableNode mutNode = mutNode(Label.of(node.getId()));
        MutableAttributed<MutableNode, ForNode> attrs = mutNode.attrs();
        applyNodeDesc(attrs, node);
        if(!StringUtils.isBlank(node.getTooltip())) {
            attrs.add("tooltip", node.getTooltip());
        }
        if(!StringUtils.isBlank(node.getFillColor())) {
            attrs.add(Color.rgb(node.getFillColor()).fill());
        }
        if(!StringUtils.isBlank(node.getColor())) {
            attrs.add(Color.rgb(node.getColor()));
        }
//        if(!StringUtils.isBlank(node.getLabel())) {
//            attrs.add("label", node.getLabel());
//        }
        if(!StringUtils.isBlank(node.getComment())) {
            attrs.add("comment", node.getComment());
        }
        return mutNode;
    }

    private static LinkSource[] createDefNode(Set<DigraphNode> nodeSet) {
        if(nodeSet == null) {
            return new LinkSource[0];
        }
        Set<LinkSource> set = new HashSet<>();
        for (DigraphNode node : nodeSet) {
            set.add(createNode(node));
        }
        return set.toArray(new LinkSource[0]);
    }

}
