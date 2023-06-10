package qf.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */
public class RecordStock {
    private Integer productId;//仓库ID
    private Integer repoId;//产品ID
    private Integer productStock;//库存数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;//设置当前时间，并且自动更新时间
    private Integer isDelete;//是否有效 0:删除 1:未删除

    List<Repository> repository;//产品表
    List<Product> product;//仓库表

    @Override
    public String toString() {
        return "RecordStock{" +
                "productId=" + productId +
                ", repoId=" + repoId +
                ", productStock=" + productStock +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", repository=" + repository +
                ", product=" + product +
                '}';
    }

    public RecordStock() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
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

    public List<Repository> getRepository() {
        return repository;
    }

    public void setRepository(List<Repository> repository) {
        this.repository = repository;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public RecordStock(Integer productId, Integer repoId, Integer productStock, Date createTime, Date updateTime, Integer isDelete, List<Repository> repository, List<Product> product) {
        this.productId = productId;
        this.repoId = repoId;
        this.productStock = productStock;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.repository = repository;
        this.product = product;
    }
}
