package com.springboot.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.springboot.common.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * api请求拦截器
 */
public class APIInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(APIInterceptor.class);

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request请求地址path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
        //判断请求地址与授权码
        if(1 == 2) {
            ResultJson resultJson = new ResultJson("商户号不正确");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(JSONObject.toJSONString(resultJson));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion被调用");

    }
}
