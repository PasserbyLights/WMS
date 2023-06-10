package qf.com.dto;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/10 15:57
 * @version：1.0
 */
public class loginDto {
    private String name;
    private String avatar;
    private String introduction;

    @Override
    public String toString() {
        return "loginDto{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Object getRoles() {
        return roles;
    }

    public void setRoles(Object roles) {
        this.roles = roles;
    }

    private Object roles;

    public loginDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
