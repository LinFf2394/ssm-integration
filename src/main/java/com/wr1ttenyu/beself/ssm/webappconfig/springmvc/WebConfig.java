package com.wr1ttenyu.beself.ssm.webappconfig.springmvc;

import com.wr1ttenyu.beself.ssm.utils.web.MyFreeMarkerView;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc // 启用 SpringMVC,相当于 xml中的 <mvc:annotation-driven/>
@ComponentScan(basePackages = "com.wr1ttenyu.beself.ssm.controller", 
	includeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = Controller.class) 
	})
public class WebConfig extends WebMvcConfigurerAdapter {

    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateStringConverter());
        registry.addConverter(new StringDateConverter());
        registry.addConverter(new StringLongConverter());
    }*/

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();

		freeMarkerConfigurer.setTemplateLoaderPaths("/WEB-INF/view/", "/WEB-INF/decorators/");
		freeMarkerConfigurer.setDefaultEncoding("utf-8");
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("template_update_delay", "");
		variables.put("locale", "zh_CN");
		variables.put("datetime_format", "yyyy-MM-dd HH:mm:ss");
		variables.put("date_format", "yyyy-MM-dd");
		variables.put("number_format", "#.##");

		freeMarkerConfigurer.setFreemarkerVariables(variables);

		return freeMarkerConfigurer;
	}

	@Bean
	public ViewResolver viewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();

		resolver.setSuffix(".ftl");
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setExposeSessionAttributes(true);
		resolver.setRequestContextAttribute("request");
		resolver.setViewClass(MyFreeMarkerView.class);

		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
