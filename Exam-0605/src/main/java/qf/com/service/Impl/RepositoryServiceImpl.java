package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Product;
import qf.com.entity.Repository;
import qf.com.mapper.RepositoryMapper;
import qf.com.service.RepositoryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 23:02
 * @version：1.0
 */
@Service
@Transactional
public class RepositoryServiceImpl implements RepositoryService {
    @Resource
    private RepositoryMapper repositoryMapper;

    @Override
    public void addRepository(Repository repository) {
        repositoryMapper.addRepository(repository);
    }

    @Override
    public void deleteRepository(Integer repoId) {
        repositoryMapper.deleteRepository(repoId);
    }

    @Override
    public void updateRepository(Repository repository) {
        repositoryMapper.updateRepository(repository);
    }

    @Override
    public Repository getRepositoryOne(Integer repoId) {
        return repositoryMapper.getRepositoryOne(repoId);
    }

    @Override
    public List<Repository> getRepositoryOne1(String repoName) {
        return repositoryMapper.getRepositoryOne1(repoName);
    }

    @Override
    public Page getRepositoryList(Integer pageNo, Integer pageSize, String repoName, Date startTime, Date endTime) {
        PageHelper.startPage(pageNo, pageSize);
        List<Repository> repositoryList = repositoryMapper.getRepositoryList(repoName,startTime,endTime);

        PageInfo info = new PageInfo(repositoryList);
        Page page = new Page();
        page.setPageNo(info.getPageNum());//当前页
        page.setPageSize(info.getPageSize());//页容量
        page.setPageCount(info.getPages());//总页数
        page.setTotal(info.getTotal());//总记录数
        page.setData(info.getList());//当前页
        page.setHasPre(info.isHasPreviousPage());//是否有上一页
        page.setHasNext(info.isHasNextPage());//是否有下一页
        return page;
    }

    @Override
    public List<Repository> getRepositoryList() {
        return repositoryMapper.getRepositoryList();
    }
}
