package com.wt.authcore.http;

import lombok.Data;

/**
 * @author tao.wang
 */
@Data
public class HttpResult {
    private int code = 200;
    private String msg;
    private Object data;

    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常,请联系管理员");
    }

    public static HttpResult error(int code, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }
}
