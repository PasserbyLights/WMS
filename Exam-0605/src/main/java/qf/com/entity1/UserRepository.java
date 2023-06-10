package qf.com.entity1;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */
public class UserRepository {
    private int repoId;
    private int userId;

    @Override
    public String toString() {
        return "UserRepository{" +
                "repoId=" + repoId +
                ", userId=" + userId +
                '}';
    }

    public int getRepoId() {
        return repoId;
    }

    public void setRepoId(int repoId) {
        this.repoId = repoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserRepository() {
    }

    public UserRepository(int repoId, int userId) {
        this.repoId = repoId;
        this.userId = userId;
    }
}
