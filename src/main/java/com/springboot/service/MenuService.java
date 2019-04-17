package com.springboot.service;



import com.springboot.entity.MenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理 服务层
 */
public interface MenuService {

    /**
     * 添加菜单
     * @param entity
     */
    public void addMenu(MenuEntity entity);

    /**
     * 查询菜单列表
     * @param map 查询条件
     * @return
     */
    public List<MenuEntity> listMenu(Map<String, Object> map);


    /**
     * 更新菜单
     * @param entity
     */
    public void updateMenu(MenuEntity entity);

    /**
     * 删除菜单
     * @param menu_id
     */
    public void deleteMenu(long menu_id);
}
