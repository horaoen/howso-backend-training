package cn.howso.backendtraining.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "测试")
public class TestController {
    
    @GetMapping("1")
    @Operation(summary = "test1")
    public String test1() {
        return "hello";
    }
}
