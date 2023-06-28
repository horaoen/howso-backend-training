package cn.howso.backendtraining.service;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IOrgInfoService extends IService<OrgInfo> {

    /**
     * 获取"中国铁塔"部门下的组织架构树
     */
    Tree getOrgTree();
}
