package com.wr1ttenyu.beself.ssm.webappconfig.filter;

import javax.servlet.annotation.WebFilter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@WebFilter(filterName = "ConfigurableSiteMeshFilter", urlPatterns = { "/*" })
public class Filter04_ConfigurableSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/decorators/decorator.ftl")
        	.addExcludedPath("/static/*").addExcludedPath("/log*")
            .setMimeTypes("text/html");
    }
}