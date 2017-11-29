package com.wr1ttenyu.beself.ssm.webappconfig.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@WebFilter(filterName = "MyFreemarkerDecorater", 
	urlPatterns = { "*.ftl" }, 
	dispatcherTypes = { DispatcherType.FORWARD })
public class Filter05_MyFreemarkerDecorater implements Filter {
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * here, it doesn't have to go on the FilterChain, just need use FreeMarkerViewResolver to resolve the sitemesh decorator page
     * and the FreeMarkerViewResolver will response the page to client
     * 
     * PS: 
     *    when we don't invoke chain.doFiler, the followed filter and servlet will not be invoked.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 从springmvc的webApplicationcontext中获取FreeMarkerConfigurer和FreeMarkerViewResolver
        // FreeMarkerConfigurer获取freemarker的local配置
        // FreeMarkerViewResolver用来渲染模板页
        WebApplicationContext webApp = RequestContextUtils.findWebApplicationContext(req);
        FreeMarkerConfigurer freemarkerConfig = webApp.getBean(FreeMarkerConfigurer.class);
        Locale locale = freemarkerConfig.getConfiguration().getLocale();
        FreeMarkerViewResolver viewResolver = webApp.getBean(FreeMarkerViewResolver.class);
        // 用springmvc来渲染目标页面,需要把请求的目标页面名字截取出来交给FreeMarkerViewResolver
        String targetFtl = req.getServletPath();
        targetFtl = targetFtl.substring(targetFtl.lastIndexOf('/') + 1, targetFtl.indexOf('.'));
        try {
            View view = viewResolver.resolveViewName(targetFtl, locale);
            view.render(null, req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
    }
}
