package com.example.jsr303.common;

public enum ResultEnum {
    SUCCESS("200", "操作成功"),
    FAILURE("-1", "操作失败");

    public String code;
    public String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}



