package com.lujian.classviz.visualize;

import com.lujian.classviz.visualize.classmeta.DigraphNodeAbstractClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeConcreteClass;
import com.lujian.classviz.visualize.classmeta.DigraphNodeEnum;
import com.lujian.classviz.visualize.classmeta.DigraphNodeInterface;

public class DigraphNodeFactory {

    public static DigraphNodeInterface createInterface(String id) {
        return new DigraphNodeInterface(id);
    }
    public static DigraphNodeAbstractClass createAbstractClass(String id) {
        return new DigraphNodeAbstractClass(id);
    }
    public static DigraphNodeConcreteClass createConcreteClass(String id) {
        return new DigraphNodeConcreteClass(id);
    }
    public static DigraphNodeEnum createEnum(String id) {
        return new DigraphNodeEnum(id);
    }

}
