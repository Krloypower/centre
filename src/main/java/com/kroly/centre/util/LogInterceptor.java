package com.kroly.centre.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName LogInterceptor
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-16 14:14
 **/
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
    /**
     * 日志跟踪标识 添加sid
     */
    private static final String SID = "SID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Map<String, String[]> map = request.getParameterMap();
        if (!CollectionUtils.isEmpty(map)){
            String[] strings = map.get("sid");
            if (!StringUtils.isEmpty(strings[0])) {
                MDC.put(SID, strings[0]);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        MDC.remove(SID);
    }
}
