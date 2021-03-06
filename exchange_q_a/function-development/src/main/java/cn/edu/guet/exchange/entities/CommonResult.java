package cn.edu.guet.exchange.entities;

import java.io.Serializable;

/**
 * @introduce:
 * @Description: 包装返回
 * @author: cyan
 * @DATE: 2021/11/3
 **/
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data; //T表达为泛型

    public CommonResult(Integer code, String message, T data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
