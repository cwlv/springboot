package com.springboot.mapper;

import com.springboot.entity.BannerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BannerMapper {

    /**
     * 添加
     * @param entity
     * @return
     */
    public int addBanner(BannerEntity entity);

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BannerEntity> listBanner(Map<String,Object> map);

    /**
     * 获取
     * @param banner_id
     * @return
     */
    public BannerEntity getBanner(long banner_id);

    /**
     * 更新
     * @param entity
     * @return
     */
    public int updateBanner(BannerEntity entity);

    /**
     * 删除
     * @param banner_id
     * @return
     */
    public int delBanner(long banner_id);
}
