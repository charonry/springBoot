package com.charon.boot.config.accessLog;

import com.charon.boot.utils.AddressIpUtils;
import com.sun.xml.internal.ws.api.message.AddressingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;
import java.util.Date;

/**
 * @description: 日志拦截器
 * @author: charon
 * @create: 2020-01-14 10:35
 **/
@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {

    // 请求开始时间标识
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    // 请求日志实体标识
    private static final String LOGGER_ACCESSLOG = "ACCESSLOG_ENTITY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 创建日志实体
        AccessLog accessLog = new AccessLog();
        // 设置IP地址
        accessLog.setIp(AddressIpUtils.getIpAdrress(request));
        // 设置请求方法,GET,POST...
        accessLog.setHttpMethod(request.getMethod());
        // 设置请求路径
        accessLog.setUrl(request.getRequestURI());
        // 设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        // 设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ACCESSLOG,accessLog);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 获取本次请求日志实体
        AccessLog accessLog = (AccessLog) request.getAttribute(LOGGER_ACCESSLOG);
        // 获取请求错误码，根据需求存入数据库，这里不保存
        int status = response.getStatus();
        accessLog.setHttpStatus(status);

        /**
         *设置访问者(这里暂时写死）
         * 因为不同的应用可能将访问者信息放在session里面，有的通过request传递，
         * 总之可以获取到，但获取的方法不同
         *
         */
        //request.getSession().getAttribute("username");
        accessLog.setUsername("admin");
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 请求开始时间
        long snedTime = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        // 设置请求时间差
        accessLog.setDuration(Integer.valueOf((currentTime - snedTime)+""));
        accessLog.setCreateTime(new Date());
        // 将sysLog对象持久化保存
        log.info(accessLog.toString());
    }
}
