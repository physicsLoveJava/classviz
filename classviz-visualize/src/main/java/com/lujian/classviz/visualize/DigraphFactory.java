package com.lujian.classviz.visualize;

import com.lujian.classviz.visualize.meta.ColorEnum;
import com.lujian.classviz.visualize.meta.Digraph;
import com.lujian.classviz.visualize.meta.NodeDesc;
import guru.nidi.graphviz.attribute.RankDir;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.attribute.Style;

public class DigraphFactory {

    public static Digraph useDefault() {
        Digraph digraph = new Digraph();

        digraph.setBgColor(ColorEnum.DARK_BLUE.getCode());
        digraph.setPad("0.5");
        digraph.setDpi(70.0);
        digraph.setRankDir(RankDir.BOTTOM_TO_TOP);

        NodeDesc desc = new NodeDesc("");
        desc.setShape(Shape.ELLIPSE);
        desc.setFont("Microsoft YaHei,微软雅黑");
        desc.setWidth("1");
        desc.setFontSize("20");
        desc.setStyle(Style.FILLED);
        desc.setFillColor(ColorEnum.YELLOW.getCode());
        desc.setColor(ColorEnum.YELLOW.getCode());
        desc.setPenWidth("1");
        desc.setLabel("");
        digraph.setNodeDesc(desc);
        return digraph;
    }

}
