package com.szw.me.demo.exception;

import com.szw.me.demo.enums.DemoResultEnum;
import lombok.Getter;

@Getter
public class DemoException extends RuntimeException {

    private String code;
    private String message;

    public DemoException(DemoResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public DemoException(String message) {
        super(message);
        this.code = DemoResultEnum.FAILED.getCode();
        this.message = message;
    }
}
