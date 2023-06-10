package qf.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */

public class Carrier {
    private Integer carrierId;//承运商ID
    private String carrierName;//承运商名称
    private String carrierLeader;//承运商负责人
    private String carrierTel;//联系电话
    private String carrierEmail;//联系邮箱
    private String carrierAddress;//联系地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//更改时间
    private Integer isDelete;//是否删除 0：删除 1：删除

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", carrierLeader='" + carrierLeader + '\'' +
                ", carrierTel='" + carrierTel + '\'' +
                ", carrierEmail='" + carrierEmail + '\'' +
                ", carrierAddress='" + carrierAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierLeader() {
        return carrierLeader;
    }

    public void setCarrierLeader(String carrierLeader) {
        this.carrierLeader = carrierLeader;
    }

    public String getCarrierTel() {
        return carrierTel;
    }

    public void setCarrierTel(String carrierTel) {
        this.carrierTel = carrierTel;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public String getCarrierAddress() {
        return carrierAddress;
    }

    public void setCarrierAddress(String carrierAddress) {
        this.carrierAddress = carrierAddress;
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

    public Carrier() {
    }

    public Carrier(Integer carrierId, String carrierName, String carrierLeader, String carrierTel, String carrierEmail, String carrierAddress, Date createTime, Date updateTime, Integer isDelete) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.carrierLeader = carrierLeader;
        this.carrierTel = carrierTel;
        this.carrierEmail = carrierEmail;
        this.carrierAddress = carrierAddress;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }
}
