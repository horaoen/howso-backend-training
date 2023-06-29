package cn.howso.backendtraining.service;

import cn.howso.backendtraining.entity.OrgInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
public class OrgInfoServiceTest {
    @Resource
    private IOrgInfoService orgInfoService;
    
    @Test
    public void orgInfoQueryPageTest() {
        Page<OrgInfo> page = orgInfoService.page(new Page<>(0, 10));
        assertNotEquals(0, page.getCurrent());
    }
}
