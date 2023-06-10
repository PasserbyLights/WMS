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

public class RecordIn {
    private Integer recordInId;//入库ID
    private Integer supplierId;//供应商ID
    private Integer productId;//产品ID
    private Integer recordInNumber;//入库数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date recordInTime;//入库时间
    private Integer userId;//入库user负责人
    private Integer repoId;//仓库ID

    private String remarks;//备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;//当前时间
    private Integer isDelete;//是否删除

    @Override
    public String toString() {
        return "RecordIn{" +
                "recordInId=" + recordInId +
                ", supplierId=" + supplierId +
                ", productId=" + productId +
                ", recordInNumber=" + recordInNumber +
                ", recordInTime=" + recordInTime +
                ", userId=" + userId +
                ", repoId=" + repoId +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getRecordInId() {
        return recordInId;
    }

    public void setRecordInId(Integer recordInId) {
        this.recordInId = recordInId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRecordInNumber() {
        return recordInNumber;
    }

    public void setRecordInNumber(Integer recordInNumber) {
        this.recordInNumber = recordInNumber;
    }

    public Date getRecordInTime() {
        return recordInTime;
    }

    public void setRecordInTime(Date recordInTime) {
        this.recordInTime = recordInTime;
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

    public RecordIn() {
    }
}
