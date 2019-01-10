package com.lujian.classviz.visualize.classmeta;

import com.lujian.classviz.visualize.meta.ColorEnum;
import com.lujian.classviz.visualize.meta.DigraphNode;
import guru.nidi.graphviz.attribute.Style;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DigraphNodeAbstractClass extends DigraphNode {

    protected String tooltip = "AbstractClass";
    protected String fillColor = ColorEnum.C_ABSTRACT_CLASS.getCode();

    public DigraphNodeAbstractClass(String id, String tooltip, String label) {
        super(id, tooltip, label);
    }

    public DigraphNodeAbstractClass(String id, String tooltip) {
        super(id, tooltip);
    }

    public DigraphNodeAbstractClass(String id) {
        super(id);
    }
}
