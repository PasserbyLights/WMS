package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Level;
import qf.com.mapper.LevelMapper;
import qf.com.service.LevelService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 20:30
 * @version：1.0
 */
@Transactional
@Service
public class LevelServiceImpl implements LevelService {
    @Resource
    private LevelMapper levelMapper;

    @Override
    public void addLevel(Level level) {
        levelMapper.addLevel(level);
    }

    @Override
    public void deleteLevel(Integer levelId) {
        levelMapper.deleteLevel(levelId);
    }

    @Override
    public void updateLevel(Level level) {
        levelMapper.updateLevel(level);
    }

    @Override
    public Level getLevelOne(Integer levelId) {
        Level levelOne = levelMapper.getLevelOne(levelId);
        return levelOne;
    }

    @Override
    public List<Level> getList() {
        return levelMapper.getLevelList();
    }

    @Override
    public Page getLevelList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Level> levels = levelMapper.getLevelList();

        PageInfo info = new PageInfo(levels);
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
}
