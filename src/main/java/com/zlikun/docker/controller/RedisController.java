package com.zlikun.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现Redis命令WEB版
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/11 10:49
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate template ;

    /**
     * GET 命令
     * @param key
     * @return
     */
    @RequestMapping(value = "/get/{key}")
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
    @RequestMapping(value = "/set/{key}/{value}")
    public Object set(@PathVariable String key ,@PathVariable String value) {
        template.boundValueOps(key).set(value);
        ModelMap model = new ModelMap() ;
        model.put("key" ,key) ;
        model.put("value" ,value) ;
        return model ;
    }

}
