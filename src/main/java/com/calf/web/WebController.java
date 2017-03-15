package com.calf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面测试控制类
 *
 * @author calf
 * @create 2017-03-10 15:52
 */
@Controller
public class WebController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host","http://www.baidu.com");
        return "index";
    }
}
