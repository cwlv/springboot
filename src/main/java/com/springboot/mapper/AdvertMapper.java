package com.springboot.mapper;

import com.springboot.entity.AdvertEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertMapper {

    /**
     * 添加
     * @param entity
     * @return
     */
    public int addAdvert(AdvertEntity entity);

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
