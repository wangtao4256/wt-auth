package com.wt.authcore.exception;


import lombok.Data;

/**
 * 自定义异常
 *
 * @author tao.wang
 */
@Data
public class MangoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;

    public MangoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MangoException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public MangoException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
