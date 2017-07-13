package com.zlikun.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/13 9:22
 */
@RestController
public class DefaultController {

    @Autowired
    StringRedisTemplate template ;

    @RequestMapping(value = "/" ,produces = "text/plain; charset=utf-8")
    public Object index() {
        return "Redis命令执行工具(WEB版)" ;
    }

    /**
     * GET 命令
     * @param key
     * @return
     */
    @RequestMapping(value = "/get/{key}" ,produces = "application/json; charset=utf-8")
    public Object get(@PathVariable String key) {
        String value = template.boundValueOps(key).get() ;
        ModelMap model = new ModelMap() ;
        model.put("key" ,key) ;
        model.put("value" ,value) ;
        return model ;
    }

    /**
     * SET 命令
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value = "/set/{key}/{value}" ,produces = "application/json; charset=utf-8")
    public Object set(@PathVariable String key ,@PathVariable String value) {
        template.boundValueOps(key).set(value);
        ModelMap model = new ModelMap() ;
        model.put("key" ,key) ;
        model.put("value" ,value) ;
        return model ;
    }

}
