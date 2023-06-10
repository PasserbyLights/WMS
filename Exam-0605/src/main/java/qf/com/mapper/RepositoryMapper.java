package qf.com.mapper;

import org.apache.ibatis.annotations.Param;
import qf.com.entity.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 23:00
 * @version：1.0
 */
public interface RepositoryMapper {
    void addRepository(Repository repository);

    void deleteRepository(Integer repoId);

    void updateRepository(Repository repository);

    Repository getRepositoryOne(Integer repoId);
    List<Repository> getRepositoryOne1(String repoName);

    List<Repository> getRepositoryList(@Param("repoName") String repoName,
                                       @Param("startTime") Date startTime,
                                       @Param("endTime") Date endTime);

    List<Repository> getRepositoryList();

}
