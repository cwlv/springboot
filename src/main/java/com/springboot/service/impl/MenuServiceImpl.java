package com.springboot.service.impl;


import com.springboot.entity.MenuEntity;
import com.springboot.mapper.MenuMapper;
import com.springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addMenu(MenuEntity entity) {
        this.menuMapper.addMenu(entity);
    }

    @Override
    public List<MenuEntity> listMenu(Map<String, Object> map) {
        return this.menuMapper.listMenu(map);
    }

    @Override
    public void updateMenu(MenuEntity entity) {
        this.menuMapper.updateMenu(entity);
    }

    @Override
    public void deleteMenu(long menu_id) {
        this.menuMapper.deleteMenu(menu_id);
    }
}
