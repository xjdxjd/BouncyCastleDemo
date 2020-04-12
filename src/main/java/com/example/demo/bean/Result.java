package com.example.demo.bean;


import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private Exception error;
    private Object data;

    public Result() {
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(int code, Exception error, Object data) {
        this.code = code;
        this.error = error;
        this.data = data;
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

    public Exception getError() {

        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Result success()
    {
        this.code = 0;
        this.message = "操作成功";
        return this;
    }

    public Result success(int code)
    {
        this.code = code;
        this.message = "操作成功";
        return this;
    }

    public Result success(String message)
    {
        this.code = 0;
        this.message = message;
        return this;
    }

    public Result success(Object data)
    {
        this.code = 0;
        this.message = "操作成功";
        this.data = data;
        return this;
    }

    public Result success(int code, String message)
    {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result success(String message, Object data)
    {
        this.code = 0;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result success(int code, String message, Object data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Result failed()
    {
        this.code = 1;
        this.message = "操作失败";
        return this;
    }

    public Result failed(int code)
    {
        this.code = code;
        this.message = "操作失败";
        return this;
    }

    public Result failed(String message)
    {
        this.code = 1;
        this.message = message;
        return this;
    }

    public Result failed(Object data)
    {
        this.code = 1;
        this.message = "操作失败";
        this.data = data;
        return this;
    }

    public Result failed(int code, String message)
    {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result failed(String message, Object data)
    {
        this.code = 1;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result failed(int code, String message, Object data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Result error()
    {
        this.code = -1;
        this.message = "程序出现未捕获异常，请及时处理!";
        return this;
    }
    public Result error(int code)
    {
        this.code = code;
        this.message = "程序出现未捕获异常，请及时处理!";
        return this;
    }
    public Result error(String message)
    {
        this.code = -1;
        this.message = message;
        return this;
    }
    public Result error(Exception error)
    {
        this.code = -1;
        this.message = "程序出现未捕获异常，请及时处理!";
        this.error = error;
        return this;
    }
    public Result error(int code, Exception error)
    {
        this.code = code;
        this.message = "程序出错，已捕获异常: "+code+"，请及时处理!";
        this.error = error;
        return this;
    }
    public Result error(String message, Exception error)
    {
        this.code = -1;
        this.message = message;
        this.error = error;
        return this;
    }
    public Result error(int code, String message, Exception error)
    {
        this.code = code;
        this.message = message;
        this.error = error;
        return this;
    }
}
