package com.szw.me.demo.enums;

import lombok.Getter;

@Getter
public enum DemoResultEnum {

    FAILED("-1", "失败"),
    DUP_KEY("10001", "数据重复"),
    NOT_FOUND("10002", "未找到数据");

    private String code;
    private String message;

    DemoResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String code) {
        String defaultValue = "";
        for (DemoResultEnum demoResultEnum : DemoResultEnum.values()) {
            if (demoResultEnum.getCode().equals(code)) {
                return demoResultEnum.getMessage();
            }
        }
        return defaultValue;
    }
}
