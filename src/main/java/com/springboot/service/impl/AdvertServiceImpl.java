package com.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.AdvertEntity;
import com.springboot.mapper.AdvertMapper;
import com.springboot.service.AdvertService;
import com.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("advertService")
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertMapper advertMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addAdvert(AdvertEntity entity) {
        return this.advertMapper.addAdvert(entity);
    }

    @Override
    public PageInfo<AdvertEntity> tabletAdvert(int pageNum, int pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);     //分页设置
        List<AdvertEntity> list = this.advertMapper.listAdvert(map);
        PageInfo<AdvertEntity> pager = new PageInfo(list);
        return pager;
    }

    @Override
    public List<AdvertEntity> listAdvert(Map<String, Object> map) {
//        if(!StringUtil.isEmpty(map.get("advert_type"))){
//            String advert_type = (String)map.get("advert_type");
//            if(this.redisTemplate.hasKey("advert_" + advert_type)){
//                return (List<AdvertEntity>)this.redisTemplate.opsForValue().get("advert_" + advert_type);
//            }else{
//                List<AdvertEntity> list = this.advertMapper.listAdvert(map);
//                this.redisTemplate.opsForValue().set("advert_" + advert_type,list);
//                return list;
//            }
//        }
        return this.advertMapper.listAdvert(map);
    }

    @Override
    public AdvertEntity getAdvert(long advert_id) {
        return this.advertMapper.getAdvert(advert_id);
    }

    @Override
    public int updateAdvert(AdvertEntity entity) {
        return this.advertMapper.updateAdvert(entity);
    }

    @Override
    public int delAdvert(long advert_id) {
        return this.advertMapper.delAdvert(advert_id);
    }
}
