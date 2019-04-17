package com.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.config.AppConfig;
import com.springboot.config.WebAppConfig;
import com.springboot.service.ConfigService;
import com.springboot.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传 控制类
 */
@RestController
@EnableConfigurationProperties({AppConfig.class})
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ConfigService configService;

    //文件上传
    @PostMapping("/fileUpload")
    public Map<String,Object> fileUpload(MultipartFile file, HttpServletRequest request){
        log.info("文件上传");
        Map<String,Object> rstMap = new HashMap();
        Map<String,Object> rstMap2 = new HashMap();
        if(file.isEmpty()){     //文件是否为空
            log.info("上传文件为空");
            rstMap.put("code",1);
            rstMap.put("msg","请选择文件");
            rstMap.put("data","");
            return rstMap;
        }
        String fileName = file.getOriginalFilename();       //原文件名称
        String fileType = fileName.substring(fileName.indexOf("."));    //文件类型

        //按年月日文件夹，存放文件
        String dateStr = DateUtil.getDateStr(new Date(),"yyyyMMdd");  //按日期文件夹
        String newFileName = UUID.randomUUID() + fileType;  //新文件名
        try {
            // 文件保存路径
            String filePath = this.appConfig.getProfile() + dateStr;
            //创建父文件夹
            log.info(filePath);
            File pfile = new File(filePath);
            pfile.mkdirs();
            // 转存文件
            filePath = filePath + "/" + newFileName;
            file.transferTo(new File(filePath));

            //访问路径
            String webPath = this.configService.getConfig("web_site").getConfig_value()  + WebAppConfig.PIC_PATH  + dateStr + "/" + newFileName;
            rstMap2.put("src",webPath);

            rstMap.put("code",0);
            rstMap.put("msg","");
            rstMap.put("data",rstMap2);
            log.info(JSONObject.toJSONString(rstMap));
            return rstMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        rstMap.put("code",1);
        rstMap.put("msg","文件上传异常");
        rstMap.put("data","");
        return rstMap;
    }
}
