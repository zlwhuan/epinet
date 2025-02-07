package com.clzk.epinet.enmu;

public enum PopulationCategory {
    INFANT(1, "幼托儿童"),
    CHILD(2, "散居儿童"),
    STUDENT(3, "学生"),
    TEACHER(4, "教师"),
    NANNY(5, "保育员及保姆"),
    CATERING(6, "餐饮食品业"),
    PUBLIC_SERVICE(7, "公共场所服务员"),
    BUSINESS(8, "商业服务"),
    MEDICAL(9, "医务人员"),
    WORKER(10, "工人"),
    MIGRANT_WORKER(11, "民工"),
    FARMER(12, "农民"),
    HERDER(13, "牧民"),
    FISHERMAN(14, "渔(船)民"),
    SAILOR(15, "海员及长途驾驶员"),
    STAFF(16, "干部职员"),
    RETIRED(17, "离退人员"),
    HOUSEHOLD(18, "家务及待业"),
    PRISONER(19, "羁押人员"),
    UNKNOWN(20, "不详"),
    OTHER(99, "其他");

    private final int code;
    private final String description;

    PopulationCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}