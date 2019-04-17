package com.springboot.mapper;


import com.springboot.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典管理 持久层
 */
@Mapper
public interface DictionaryMapper {

    /**
     * 增加 字典
     * @param entity
     * @return
     */
    public int addDic(DictionaryEntity entity);

    /**
     * 查询字典列表
     * @param map
     * @return
     */
    public List<DictionaryEntity> listDic(Map<String, Object> map);

    /**
     * 获取字典
     * @param dic_type
     * @param dic_code
     * @return
     */
    public DictionaryEntity getDic(@Param("dic_type") String dic_type, @Param("dic_code") String dic_code);

    /**
     * 更新字典
     * @param entity
     * @return
     */
    public int updateDic(DictionaryEntity entity);

    /**
     * 删除字典
     * @param dic_id
     * @return
     */
    public int delDic(long dic_id);

    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    public int delBatchDic(@Param("ids") List<String> ids);
}
