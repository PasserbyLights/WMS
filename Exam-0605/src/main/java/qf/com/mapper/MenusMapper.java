package qf.com.mapper;

import qf.com.entity.Department;
import qf.com.entity.Menus;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 14:10
 * @version：1.0
 */
public interface MenusMapper {
    void addMenus(Menus menus);

    void deleteMenus(Integer menusId);

    void updateMenus(Menus menus);

    Menus getMenusOne(Integer menusId);

    List<Menus> getMenusList();
}
