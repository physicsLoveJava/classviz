package com.lujian.classviz.visualize.classmeta;

import com.lujian.classviz.visualize.meta.ColorEnum;
import com.lujian.classviz.visualize.meta.DigraphNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DigraphNodeConcreteClass extends DigraphNode {

    protected String tooltip = "Class";
    protected String fillColor = ColorEnum.C_CONCRETE_CLASS.getCode();

    public DigraphNodeConcreteClass(String id, String tooltip, String label) {
        super(id, tooltip, label);
    }

    public DigraphNodeConcreteClass(String id, String tooltip) {
        super(id, tooltip);
    }

    public DigraphNodeConcreteClass(String id) {
        super(id);
    }
}
