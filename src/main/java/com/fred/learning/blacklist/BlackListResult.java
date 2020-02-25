package com.fred.learning.blacklist;


import java.io.Serializable;

/**
 * @author yige.song
 * @version V1.0
 * @Title: BlackListResult
 * @Description: 返回值
 * @date 2019/7/12 10:32 AM
 */
public class BlackListResult<T> implements Serializable {

    private static final long serialVersionUID = -7435076539310520393L;

    private int code;
    private Boolean success;
    private String message;
    private T data;

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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BlackListResult fail(int code, String message) {
        BlackListResult result = new BlackListResult();
        result.setCode(code);
        result.setMessage(message);

        return result;
    }

    public static <T> BlackListResult success(T data) {
        BlackListResult result = new BlackListResult();
        result.setCode(0);
        result.setMessage("Success and hit.");
        result.setData(data);

        return result;
    }

}
