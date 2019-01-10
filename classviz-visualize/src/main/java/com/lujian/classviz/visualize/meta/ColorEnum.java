package com.lujian.classviz.visualize.meta;

public enum ColorEnum {

    DARK_BLUE("#2e3e56"),
    DARK_GRAY("#fcfcfc"),
    WHITE("#ffffff"),
    DARK_LINE("#445773"),
    RED("#ea555b"),
    YELLOW("#edad56"),
    GOLD("#AB6D16"),
    DARK_GREEN("#29b89d"),
    PURPLE("#9362a8"),
    PINK("#f2688d"),
    GREEN("#a5cf80"),
    BLUE("#8eabd9"),
    C_INTERFACE("#B4A7E5"),
    C_ABSTRACT_CLASS("#22D223"),
    C_CONCRETE_CLASS("#ADD1B2"),
    C_ENUM("#E3664A")
    ;

    private String code;

    ColorEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
