package qf.com.entity1;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */
public class RoleMenus {
    private Integer roleId;
    private Integer menuId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//更新时间
    private Integer isDelete;//是否删除 0:删除 1:未删除

}
