package com.springboot.service;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.AdvertEntity;

import java.util.List;
import java.util.Map;

/**
 * 广告类 服务层
 * 10banner 20友情链接 30广告
 */
public interface AdvertService {

    /**
     * 添加
     * @param entity
     * @return
     */
    public int addAdvert(AdvertEntity entity);

    /**
     * 列表-分页
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    public PageInfo<AdvertEntity> tabletAdvert(int pageNum, int pageSize, Map<String, Object> map);

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<AdvertEntity> listAdvert(Map<String,Object> map);

    /**
     * 获取
     * @param advert_id
     * @return
     */
    public AdvertEntity getAdvert(long advert_id);

    /**
     * 更新
     * @param entity
     * @return
     */
    public int updateAdvert(AdvertEntity entity);

    /**
     * 删除
     * @param advert_id
     * @return
     */
    public int delAdvert(long advert_id);
}
