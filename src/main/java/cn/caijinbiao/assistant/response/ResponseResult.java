package cn.caijinbiao.assistant.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public ResponseResult(String message) {
        this.message = message;
    }

    public ResponseResult(Throwable e) {
        this.message = e.toString();
    }
}
