package com.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.ConfigEntity;
import com.springboot.mapper.ConfigMapper;
import com.springboot.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addConfig(ConfigEntity entity) {
        return this.configMapper.addConfig(entity);
    }

    @Override
    public PageInfo<ConfigEntity> listConfig(int pageNum, int pageSize,Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);     //分页设置
        List<ConfigEntity> list = this.configMapper.listConfig(map);
        PageInfo<ConfigEntity> pager = new PageInfo(list);
        return pager;
    }

    @Override
    public ConfigEntity getConfig(String config_key) {
//        if(!this.redisTemplate.hasKey("config" + config_key)){
//            ConfigEntity config = this.configMapper.getConfig(config_key);
//            this.redisTemplate.opsForValue().set("config" + config_key,config);
//            return config;
//        }
//        return (ConfigEntity)this.redisTemplate.opsForValue().get("config" + config_key);
        return this.configMapper.getConfig(config_key);
    }

    @Override
    public int updateConfig(ConfigEntity entity) {
        return this.configMapper.updateConfig(entity);
    }

    @Override
    public int delConfig(long config_id) {
        return this.configMapper.delConfig(config_id);
    }
}
