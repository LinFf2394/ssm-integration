package com.wr1ttenyu.beself.ssm.utils.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 继承springmvc的FreeMarkerView,可以对spring渲染FreeMarker的共同属性值做自定义扩展
 *
 * @author wr1ttenyu
 */
public class MyFreeMarkerView extends FreeMarkerView {
    
    /**
     * 添加所有页面渲染过程中需要的公共属性
     */
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        
        model.put("basePath", request.getContextPath());
        
    }
}
