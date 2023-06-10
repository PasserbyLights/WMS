package qf.com.entity1;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */

public class SysLog{
    private long logId;
    private Integer type;
    private String ipAddr;
    private String methodName;
    private String method;
    private String nickName;
    private Timestamp createTime;

    @Override
    public String toString() {
        return "SysLog{" +
                "logId=" + logId +
                ", type=" + type +
                ", ipAddr='" + ipAddr + '\'' +
                ", methodName='" + methodName + '\'' +
                ", method='" + method + '\'' +
                ", nickName='" + nickName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public SysLog() {
    }

    public SysLog(long logId, Integer type, String ipAddr, String methodName, String method, String nickName, Timestamp createTime) {
        this.logId = logId;
        this.type = type;
        this.ipAddr = ipAddr;
        this.methodName = methodName;
        this.method = method;
        this.nickName = nickName;
        this.createTime = createTime;
    }
}
