package qf.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */
//客户级别表
public class Level {
    private Integer levelId;//客户级别ID,主键自增
    private String levelName;//客户级别名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//设置当前时间，并且自动更新时间
    private Integer isDelete;//是否删除 0:删除 1:未删除

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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

    public Level() {
    }

    public Level(Integer levelId, String levelName, Date createTime, Date updateTime, Integer isDelete) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }
}
