package cn.caijinbiao.assistant.exception;

public class IsNullOrEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IsNullOrEmptyException() {
    }

    public IsNullOrEmptyException(String message) {
        super(message);
    }

    public IsNullOrEmptyException(Throwable cause) {
        super(cause);
    }

    public IsNullOrEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsNullOrEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
