package com.lujian.classviz.visualize.meta;

import guru.nidi.graphviz.attribute.Arrow;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.attribute.Style;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class NodeDesc {

    protected Shape shape;
    protected Style style;
    protected Style edgeStyle;
    protected Arrow edgeArrow;
    protected String font;
    protected String fontSize;
    protected String width;
    protected String height;
    protected String fillColor;
    protected String color;
    protected String penWidth;
    protected String label;

    public NodeDesc(String label) {
        this.shape = Shape.RECTANGLE;
        this.font = "Microsoft YaHei,微软雅黑";
        this.fontSize = "14";
        this.width = "0.6";
        this.style = Style.FILLED;
        this.edgeStyle = Style.SOLID;
        this.edgeArrow = Arrow.NORMAL.open();
        this.fillColor = (ColorEnum.YELLOW.getCode());
        this.color = ColorEnum.YELLOW.getCode();
        this.label = label;
    }

}
