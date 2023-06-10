package qf.com.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */

public class RecordOut {
    private Integer recordOutId;//出库ID
    private Integer customerId;//客户ID
    private Integer productId;//产品ID
    private Integer recordOutNumber;//出库数量
    private Date recordOutTime;//出货时间
    private Integer userId;//出库负责人
    private Integer repoId;//仓库ID
    private String remarks;//备注
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private Integer isDelete;//是否删除

    @Override
    public String toString() {
        return "RecordOut{" +
                "recordOutId=" + recordOutId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", recordOutNumber=" + recordOutNumber +
                ", recordOutTime=" + recordOutTime +
                ", userId=" + userId +
                ", repoId=" + repoId +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getRecordOutId() {
        return recordOutId;
    }

    public void setRecordOutId(Integer recordOutId) {
        this.recordOutId = recordOutId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRecordOutNumber() {
        return recordOutNumber;
    }

    public void setRecordOutNumber(Integer recordOutNumber) {
        this.recordOutNumber = recordOutNumber;
    }

    public Date getRecordOutTime() {
        return recordOutTime;
    }

    public void setRecordOutTime(Date recordOutTime) {
        this.recordOutTime = recordOutTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public RecordOut() {
    }
}
