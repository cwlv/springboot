package com.springboot.service;


import com.github.pagehelper.PageInfo;
import com.springboot.entity.DictionaryEntity;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    /**
     * 添加 字典
     * @param entity
     * @return
     */
    public int addDic(DictionaryEntity entity);

    /**
     * 查询 字典列表
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param map 查询条件
     * @return
     */
    public PageInfo<DictionaryEntity> tabletDic(int pageNum, int pageSize, Map<String, Object> map);

    /**
     * 查询 字典列表 - 不分页
     * @param map
     * @return
     */
    public List<DictionaryEntity> listDic(Map<String, Object> map);


    /**
     * 获取字典
     * @param dic_type 类型
     * @param dic_code 编码
     * @return
     */
    public DictionaryEntity getDic(String dic_type, String dic_code);

    /**
     * 更新字典
     * @param entity
     * @return
     */
    public int updateDic(DictionaryEntity entity);

    /**
     * 删除
     * @param dic_id
     * @return
     */
    public int delDic(long dic_id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int delBatchDic(List<String> ids);
}
