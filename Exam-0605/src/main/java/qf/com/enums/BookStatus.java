package qf.com.enums;

/**
 * 定义相应状态吗
 */
public enum BookStatus {

    OK(0,"成功"),
    CATEGORY_ERROR(1,"查询分类列表失败"),
    FILE_SUFFIX_ERROR(2,"文件格式不匹配"),

    ERROR(-1,"系统异常");

    private int code;
    private String msg;

    BookStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BookStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
