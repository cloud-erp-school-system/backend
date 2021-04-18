package org.erp.school.global.enums;

public enum SizeCategory {
    NANO("0-10"),
    MICRO("11-20"),
    SMALLER("21-30"),
    SMALL("31-50"),
    MEDIUM("51-100"),
    BIG("101-200"),
    BIGGER("201-500"),
    HUGE("501-1000"),
    VAST("1001-10000+");

    private String size;

    SizeCategory(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
