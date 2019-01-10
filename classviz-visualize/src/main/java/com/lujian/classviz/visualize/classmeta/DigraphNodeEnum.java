package com.lujian.classviz.visualize.classmeta;

import com.lujian.classviz.visualize.meta.ColorEnum;
import com.lujian.classviz.visualize.meta.DigraphNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DigraphNodeEnum extends DigraphNode {

    protected String tooltip = "Enum";
    protected String fillColor = ColorEnum.C_ENUM.getCode();

    public DigraphNodeEnum(String id, String tooltip, String label) {
        super(id, tooltip, label);
    }

    public DigraphNodeEnum(String id, String tooltip) {
        super(id, tooltip);
    }

    public DigraphNodeEnum(String id) {
        super(id);
    }
}
