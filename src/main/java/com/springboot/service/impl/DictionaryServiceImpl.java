package com.springboot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.DictionaryEntity;
import com.springboot.mapper.DictionaryMapper;
import com.springboot.service.DictionaryService;
import com.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wordService")
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addDic(DictionaryEntity entity) {
        return this.dictionaryMapper.addDic(entity);
    }

    @Override
    public PageInfo<DictionaryEntity> tabletDic(int pageNum, int pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);     //分页设置
        List<DictionaryEntity> list = this.dictionaryMapper.listDic(map);
        PageInfo<DictionaryEntity> pager = new PageInfo(list);
        return pager;
    }

    @Override
    public List<DictionaryEntity> listDic(Map<String, Object> map) {
//        if(!StringUtil.isEmpty(map.get("dic_type"))){
//            String dic_type = (String)map.get("dic_type");
//            if(this.redisTemplate.hasKey("menu_" + dic_type)){    //
//                return (List<DictionaryEntity>)redisTemplate.opsForValue().get("menu_"+dic_type);
//            }else{
//                List<DictionaryEntity> list = this.dictionaryMapper.listDic(map);
//                this.redisTemplate.opsForValue().set("menu_"+dic_type,list);
//                return list;
//            }
//        }
        return this.dictionaryMapper.listDic(map);
    }

    @Override
    public DictionaryEntity getDic(String word_type, String word_code) {
        return this.dictionaryMapper.getDic(word_type,word_code);
    }

    @Override
    public int updateDic(DictionaryEntity entity) {
        return this.dictionaryMapper.updateDic(entity);
    }

    @Override
    public int delDic(long word_id) {
        return this.dictionaryMapper.delDic(word_id);
    }

    @Override
    public int delBatchDic(List<String> ids) {
        return this.dictionaryMapper.delBatchDic(ids);
    }
}
