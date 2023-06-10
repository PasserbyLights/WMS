package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Department;
import qf.com.entity.Menus;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 14:11
 * @version：1.0
 */
public interface MenusService {
    void addMenus(Menus menus);

    void deleteMenus(Integer menusId);

    void updateMenus(Menus menus);

    Menus getMenusOne(Integer menusId);

    Page getMenusList(Integer pageNo, Integer pageSize);
}
