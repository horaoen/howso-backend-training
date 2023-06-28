package cn.howso.backendtraining.controller;

import cn.howso.backendtraining.service.IOrgInfoService;
import cn.hutool.core.lang.tree.Tree;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orgInfo")
@Tag(name = "组织架构")
public class OrgInfoController {
    private final IOrgInfoService orgInfoService;

    public OrgInfoController(IOrgInfoService orgInfoService) {
        this.orgInfoService = orgInfoService;
    }
    
    @Operation(summary = "组织架构树")
    @GetMapping("tree")
    public Tree getOrgTree() {
        return this.orgInfoService.getOrgTree();
    }
}
