package com.wr1ttenyu.beself.ssm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		mv.addObject("param", "页面参数");
		return mv;
	}
	
	@RequestMapping(value="/rest/testmap", method=RequestMethod.POST)
    public ModelAndView home(@RequestBody Map<String, String> mapParam) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        mv.addObject("param", "param");
        return mv;
    }
}
