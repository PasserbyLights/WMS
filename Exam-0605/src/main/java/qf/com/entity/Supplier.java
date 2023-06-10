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
//供应商信息表
public class Supplier {
    private Integer supplierId;//供应商ID,主键自增
    private String supplierName;//供应商信息,如果为个人(非公司),那么当前字段和SUPPLIER_LEADER信息相同,如果为公司,那么是公司名称
    private String supplierLeader;//负责人,如果为个人(非公司),那么当前字段和SUPPLIER_NAME信息相同
    private String supplierTel;//联系电话
    private String supplierEmail;//邮箱
    private String supplierAddress;//地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//设置当前时间，并且自动更新时间
    private Integer isDelete;//是否有效 0:删除 1:未删除

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierLeader='" + supplierLeader + '\'' +
                ", supplierTel='" + supplierTel + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierLeader() {
        return supplierLeader;
    }

    public void setSupplierLeader(String supplierLeader) {
        this.supplierLeader = supplierLeader;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
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

    public Supplier() {
    }

    public Supplier(Integer supplierId, String supplierName, String supplierLeader, String supplierTel, String supplierEmail, String supplierAddress, Date createTime, Date updateTime, Integer isDelete) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierLeader = supplierLeader;
        this.supplierTel = supplierTel;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }
}
