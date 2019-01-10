package com.lujian.classviz.visualize.classmeta;

import com.lujian.classviz.visualize.meta.ColorEnum;
import com.lujian.classviz.visualize.meta.DigraphNode;
import guru.nidi.graphviz.attribute.Style;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DigraphNodeInterface extends DigraphNode {

    protected String tooltip = "Interface";
    protected String fillColor = ColorEnum.C_INTERFACE.getCode();
    protected Style edgeStyle = Style.DASHED;

    public DigraphNodeInterface(String id, String tooltip, String label) {
        super(id, tooltip, label);
    }

    public DigraphNodeInterface(String id, String tooltip) {
        super(id, tooltip);
    }

    public DigraphNodeInterface(String id) {
        super(id);
    }
}
