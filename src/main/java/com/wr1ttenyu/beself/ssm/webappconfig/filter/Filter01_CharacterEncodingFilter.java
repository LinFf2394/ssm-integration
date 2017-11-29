package com.wr1ttenyu.beself.ssm.webappconfig.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.web.filter.CharacterEncodingFilter;

@WebFilter(filterName = "CharacterEncodingFilter",
		initParams= {
			@WebInitParam(name=	"encoding",value="utf-8"),
			@WebInitParam(name=	"forceRequestEncoding",value="true"),
			@WebInitParam(name=	"forceResponseEncoding",value="true")
		},
		urlPatterns= {"/*"})
public class Filter01_CharacterEncodingFilter extends CharacterEncodingFilter {

}
