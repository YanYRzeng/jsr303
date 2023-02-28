
package com.example.jsr303.common;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fjh
 * @create: 2021-02-26 11:34
 * <p>
 * 统一结果返回
 */
@Data
public class R<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    static JSONObject emptyJson = new JSONObject();


    public static <T> R ok() {
        return ok(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg);
    }

    public static <T> R ok(String msg) {
        return ok(ResultEnum.SUCCESS.code, msg);
    }

    public static <T> R ok(T data) {
        return ok(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg, data);
    }

    public static <T> R ok(String code, String msg) {
        return ok(code, msg, emptyJson);
    }

    public static <T> R ok(String code, String msg, T data) {
        return info(code, msg, data);
    }

    public static <T> R error() {
        return error(ResultEnum.FAILURE.code, ResultEnum.FAILURE.msg);
    }

    public static <T> R error(String msg) {
        return error(ResultEnum.FAILURE.code, msg);
    }

    public static <T> R error(T data) {
        return error(ResultEnum.FAILURE.code, ResultEnum.FAILURE.msg, data);
    }

    public static <T> R error(String code, String msg) {
        return error(code,msg,emptyJson);
    }

    public static <T> R error(String code, String msg, T data) {
        return info(code,msg,data);
    }

    public static <T> R info(String code, String msg, T data) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        if (null == data) {
            r.setData(emptyJson);
        } else if (data instanceof String) {
            List<String> list = new ArrayList<>();
            list.add(data.toString());
            r.setData(list);
        }
        return r;
    }

    public R() {
    }


    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
