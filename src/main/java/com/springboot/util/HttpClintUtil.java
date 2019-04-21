package com.springboot.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * httpclint请求
 *         <dependency>
 *             <groupId>org.apache.httpcomponents</groupId>
 *             <artifactId>httpclient</artifactId>
 *             <version>4.5.5</version>
 *         </dependency>
 */
public class HttpClintUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpClintUtil.class);

    /**
     * get请求，参数拼接在地址上
     * @param url 请求地址加参数
     * @return 响应
     */
    public static String httpGet(String url)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //发送get请求
            response = httpClient.execute(httpGet);
            if(response != null && (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK || (response.getEntity() != null && !"".equals(response.getEntity())))){
                //有些碰哒鬼一样，返回不是200，也有数据
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * httpGet请求
     * @param url 请求地址
     * @param params 请求参数
     * @param hearder 请求header
     * @return
     */
    public static String httpGet(String url,Map<String,String> params,Map<String,String> hearder){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> pairs = new ArrayList<>();
        //编辑请求参数
        if(params != null && params.size() != 0){
            for(Map.Entry<String,String> entry : params.entrySet()){
                pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            //设置请求参数
            builder.setParameters(pairs);
            HttpGet httpGet = new HttpGet(builder.build());
            //设置请求header
//            httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            if(hearder != null && hearder.size() != 0){
                for(Map.Entry<String,String> entry : hearder.entrySet()){
                    httpGet.setHeader(entry.getKey(),entry.getValue());
                }
            }
            //发送get请求
            response = httpClient.execute(httpGet);
            if(response != null && (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK || (response.getEntity() != null && !"".equals(response.getEntity())))){
                //有些碰哒鬼一样，返回不是200，也有数据
                return EntityUtils.toString(response.getEntity());
            }
        } catch (URISyntaxException e) {
            log.error("get请求提交失败:" + url,e);
        } catch (ClientProtocolException e) {
            log.error("get请求提交失败:" + url,e);
        } catch (IOException e) {
            log.error("get请求提交失败:" + url,e);
        }finally {
            try {
                httpClient.close();
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * post请求
     * @param url 请求地址
     * @param params 请求参数
     * @param hearder 请求header
     * @return
     */
    public String postMap(String url,Map<String,String> params,Map<String,String> hearder) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置http请求header
        if(hearder != null && hearder.size() != 0){
            for(Map.Entry<String,String> entry : hearder.entrySet()){
                httpPost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        //编辑请求参数
        if(params != null && params.size() != 0){
            for(Map.Entry<String,String> entry : params.entrySet()){
                pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            response = httpClient.execute(httpPost);
            if(response != null && (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK || (response.getEntity() != null && !"".equals(response.getEntity())))){
                return EntityUtils.toString(response.getEntity());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
