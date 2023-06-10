package qf.com.service;

import org.apache.ibatis.annotations.Param;
import qf.com.dto.Page;
import qf.com.entity.RecordStock;
import qf.com.entity.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 23:02
 * @version：1.0
 */
public interface RepositoryService {
    void addRepository(Repository repository);

    void deleteRepository(Integer repoId);

    void updateRepository(Repository repository);

    Repository getRepositoryOne(Integer repoId);
    List<Repository> getRepositoryOne1(String repoName);

    Page getRepositoryList(Integer pageNo, Integer pageSize, String repoName, Date startTime, Date endTime);

    List<Repository> getRepositoryList();

}
