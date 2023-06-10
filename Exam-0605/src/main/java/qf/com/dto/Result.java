package qf.com.dto;

import qf.com.enums.BookStatus;

/**
 * API的统一返回格式类
 */
public class Result {

    /**
     * 响应编码
     */
    private Integer code = BookStatus.OK.getCode();;
    /**
     * 响应消息
     */
    private String msg = BookStatus.OK.getMsg();
    /**
     * 响应数据
     */
    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(BookStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
