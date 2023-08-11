package cn.howso.backendtraining.controller;

import cn.howso.backendtraining.service.IOrgInfoService;
import cn.hutool.core.lang.tree.Tree;
import com.horaoen.devkit.Result;
import com.horaoen.devkit.UnifiedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orgInfo")
@Tag(name = "组织架构")
@RequiredArgsConstructor
public class OrgInfoController {
    private final IOrgInfoService orgInfoService;
    
    @Operation(summary = "组织架构树")
    @GetMapping("tree")
    public Tree<String> getOrgTree() {
        return this.orgInfoService.getOrgTree();
    }
    
    @Operation(summary = "获取携带用户的组织架构树")
    @GetMapping("treeWithUser") 
    public Tree<String> getOrgTreeWithUse() {
        return this.orgInfoService.getOrgTreeWithUser();
    }
    
    @GetMapping("test")
    public UnifiedResponse<?> test() {
        int b = 2 / 0;
        return Result.ok("aa");
    }
}
