package com.wr1ttenyu.beself.ssm.webappconfig.filter;

import javax.servlet.annotation.WebFilter;

import org.springframework.web.filter.HttpPutFormContentFilter;

@WebFilter(filterName = "HttpPutFormContentFilter",
		urlPatterns= {"/*"})
public class Filter03_HttpPutFormContentFilter extends HttpPutFormContentFilter {

}
