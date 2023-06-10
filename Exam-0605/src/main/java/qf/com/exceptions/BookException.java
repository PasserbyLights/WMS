package qf.com.exceptions;

import qf.com.enums.BookStatus;

/**
 * 自定义异常
 */
public class BookException extends RuntimeException {

    private int code;

    public BookException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BookException(BookStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookException{" +
                "code=" + code +
                '}';
    }
}
