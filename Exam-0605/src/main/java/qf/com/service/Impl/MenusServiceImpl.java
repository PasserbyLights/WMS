package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Department;
import qf.com.entity.Menus;
import qf.com.entity.Source;
import qf.com.mapper.MenusMapper;
import qf.com.service.MenusService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 14:13
 * @version：1.0
 */
@Service
@Transactional
public class MenusServiceImpl implements MenusService {
    @Resource
    private MenusMapper menusMapper;

    @Override
    public void addMenus(Menus menus) {
        menusMapper.addMenus(menus);
    }

    @Override
    public void deleteMenus(Integer menusId) {
        menusMapper.deleteMenus(menusId);
    }

    @Override
    public void updateMenus(Menus menus) {
        menusMapper.updateMenus(menus);
    }

    @Override
    public Menus getMenusOne(Integer menusId) {
        return menusMapper.getMenusOne(menusId);
    }

    @Override
    public Page getMenusList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Menus> menusList = menusMapper.getMenusList();

        PageInfo info = new PageInfo(menusList);
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
