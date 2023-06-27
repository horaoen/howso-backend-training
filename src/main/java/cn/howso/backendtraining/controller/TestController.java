package cn.howso.backendtraining.controller;

import cn.hutool.db.nosql.redis.RedisDS;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/test")
@Tag(name = "测试")
public class TestController {
    
    @GetMapping("1")
    @Operation(summary = "test1")
    public String test1() {
        return "hello";
    }
    
    @GetMapping("2")
    @Operation(summary = "redis test")
    public String test2() {
        Jedis jedis = RedisDS.create().getJedis();
        jedis.set("hello", "hello world");
        return jedis.get("hello");
    }
}
