package qf.com.controler;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Repository;
import qf.com.service.RepositoryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 23:20
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class RepositoryControler {
    @Resource
    private RepositoryService repositoryService;

    @RequestMapping(value = "/addRepository")
    public Result addRepository(@RequestBody Repository repository) {
        repository.setUpdateTime(new Date());
        repositoryService.addRepository(repository);
        return new Result();
    }

    @RequestMapping(value = "/deleteRepository")
    public Result deleteRepository(Integer repoId) {
        repositoryService.deleteRepository(repoId);
        return new Result();
    }

    @RequestMapping(value = "/updateRepository")
    public Result updateRepository(@RequestBody Repository repository) {
        repository.setUpdateTime(new Date());
        repositoryService.updateRepository(repository);
        return new Result();
    }

    @RequestMapping(value = "/getRepositoryOne")
    public Result getRepositoryOne(Integer repoId) {
        Repository repoOne = repositoryService.getRepositoryOne(repoId);
        return new Result(repoOne);
    }
    @RequestMapping(value = "/getRepositoryOne1")
    public Result getRepositoryOne1(String repoName) {
        List<Repository> repoOne = repositoryService.getRepositoryOne1(repoName);
        return new Result(repoOne);
    }

    @RequestMapping(value = "/getRepositoryList")
    public Result getRepositoryList(Integer pageNo, Integer pageSize, String repoName,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        Page repoList = repositoryService.getRepositoryList(pageNo, pageSize,repoName,startTime,endTime);
        return new Result(repoList);
    }
    @RequestMapping(value = "/getListRepository")
    public Result getListRepository() {
        List<Repository> repositoryList = repositoryService.getRepositoryList();
        return new Result(repositoryList);
    }
}
