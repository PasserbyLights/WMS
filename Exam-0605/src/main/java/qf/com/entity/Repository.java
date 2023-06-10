package qf.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */

public class Repository {
    private Integer repoId;//仓库ID,主键自增
    private String repoName;//仓库名称
    private String repoAddress;//仓库地址
    private String repoArea;//仓库面积,单位:平方米
    private String repoDesc;//仓库描述(备注)
    private Byte repoStatus;//仓库状态 0:故障 1:正常 2:已满 3:废弃

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//更新时间
    private Integer isDelete;//是否删除 0:删除 1:未删除

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoAddress() {
        return repoAddress;
    }

    public void setRepoAddress(String repoAddress) {
        this.repoAddress = repoAddress;
    }

    public String getRepoArea() {
        return repoArea;
    }

    public void setRepoArea(String repoArea) {
        this.repoArea = repoArea;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public void setRepoDesc(String repoDesc) {
        this.repoDesc = repoDesc;
    }

    public Byte getRepoStatus() {
        return repoStatus;
    }

    public void setRepoStatus(Byte repoStatus) {
        this.repoStatus = repoStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repoId=" + repoId +
                ", repoName='" + repoName + '\'' +
                ", repoAddress='" + repoAddress + '\'' +
                ", repoArea='" + repoArea + '\'' +
                ", repoDesc='" + repoDesc + '\'' +
                ", repoStatus=" + repoStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Repository() {
    }
}
