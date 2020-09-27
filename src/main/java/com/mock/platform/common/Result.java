package com.mock.platform.common;

/**
 * @author swk5001400
 */
public class Result {

    private static final int SUCCESS_CODE = 20000;
    private static final int FAIL_CODE = 30000;
    public static final int ALREADY_EXIST_CODE = 30001;
    public static final int INPUT_EMPTY = 30002;


    private int code;
    private String message;
    private Object data;

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(SUCCESS_CODE,null,null);
    }
    public static Result success(Object data) {
        return new Result(SUCCESS_CODE,"", data);
    }
    public static Result fail(String message) {
        return new Result(FAIL_CODE, message,null);
    }

    /**
     * 传入失败状态码，返回Result结果
     * @param code 失败状态码
     * @param message 文本提示
     * @return Result结果
     */
    public static Result fail(int code, String message) {
        return new Result(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
