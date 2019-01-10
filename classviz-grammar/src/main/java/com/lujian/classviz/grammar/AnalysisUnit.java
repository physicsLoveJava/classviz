package com.lujian.classviz.grammar;

import java.util.List;

public class AnalysisUnit {

    String className;
    ClassTypeEnum classType;
    String packageDeclaration;
    String extendedType;
    List<String> implementedTypeList;

    public ClassTypeEnum getClassType() {
        return classType;
    }

    public void setClassType(ClassTypeEnum classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageDeclaration() {
        return packageDeclaration;
    }

    public void setPackageDeclaration(String packageDeclaration) {
        this.packageDeclaration = packageDeclaration;
    }

    public String getExtendedType() {
        return extendedType;
    }

    public void setExtendedType(String extendedType) {
        this.extendedType = extendedType;
    }

    public List<String> getImplementedTypeList() {
        return implementedTypeList;
    }

    public void setImplementedTypeList(List<String> implementedTypeList) {
        this.implementedTypeList = implementedTypeList;
    }

    @Override
    public String toString() {
        return "AnalysisUnit{" +
                "className='" + className + '\'' +
                ", classType=" + classType +
                ", packageDeclaration='" + packageDeclaration + '\'' +
                ", extendedType='" + extendedType + '\'' +
                ", implementedTypeList=" + implementedTypeList +
                '}';
    }
}
