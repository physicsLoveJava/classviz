package com.lujian.classviz.visualize.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class DigraphNode extends NodeDesc {

    protected String tooltip;
    protected String comment;
    protected String id;

    public DigraphNode(String id, String tooltip, String label) {
        super(label);
        this.id = id;
        this.tooltip = tooltip;
    }

    public DigraphNode(String id, String tooltip) {
        super(id);
        this.id = id;
        this.tooltip = tooltip;
    }

    public DigraphNode(String id) {
        super(id);
        this.id = id;
    }
}
