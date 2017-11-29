package com.wr1ttenyu.beself.ssm.webappconfig.filter;

import javax.servlet.annotation.WebFilter;

import org.springframework.web.filter.HiddenHttpMethodFilter;

@WebFilter(filterName = "HiddenHttpMethodFilter",
		urlPatterns= {"/*"})
public class Filter02_HiddenHttpMethodFilter extends HiddenHttpMethodFilter {

}
