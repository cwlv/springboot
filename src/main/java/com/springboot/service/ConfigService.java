package com.springboot.service;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.ConfigEntity;

import java.util.Map;

public interface ConfigService {

    /**
     * 新增
     * @param entity
     * @return
     */
    public int addConfig(ConfigEntity entity);

    /**
     * 列表
     * @param map 查询条件
     * @return
     */
    public PageInfo<ConfigEntity> listConfig(int pageNum, int pageSize,Map<String,Object> map);

    /**
     * 获取
     * @param config_key
     * @return
     */
    public ConfigEntity getConfig(String config_key);

    /**
     * 更新
     * @param entity
     * @return
     */
    public int updateConfig(ConfigEntity entity);

    /**
     * 删除
     * @param config_id
     * @return
     */
    public int delConfig(long config_id);
}
