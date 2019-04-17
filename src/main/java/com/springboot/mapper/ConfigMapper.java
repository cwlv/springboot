package com.springboot.mapper;

import com.springboot.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ConfigMapper {

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
    public List<ConfigEntity> listConfig(Map<String,Object> map);

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
