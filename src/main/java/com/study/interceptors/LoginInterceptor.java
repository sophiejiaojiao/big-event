package com.study.interceptors;

import com.study.pojo.Result;
import com.study.utils.JwtUtil;
import com.study.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 拦截器：此处统一验证令牌
 * 拦截器（Interceptor）是一种用于处理HTTP请求的中间件，它可以在请求被处理之前或之后执行一些操作，如验证用户的身份、记录日志、处理错误等。
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true; // 解析成功，放行
        } catch (Exception e) {
            // http响应状态码为401
            response.setStatus(401);
            return false; // 解析失败，不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal中的数据，防止内存泄漏
        ThreadLocalUtil.remove();
        System.out.println("remove ThreadLocal");
    }
}
