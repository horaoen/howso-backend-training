package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.howso.backendtraining.mapper.OrgInfoMapper;
import cn.howso.backendtraining.service.IOrgInfoService;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrgInfoServiceImpl extends ServiceImpl<OrgInfoMapper, OrgInfo> implements IOrgInfoService {

    private static final String CHINA_TOWER_ROG_CODE = "100000";
    @Override
    public Tree getOrgTree() {
        // 构建所有部门treeNodes
        List<TreeNode<String>> treeNodes = this.list().stream().map(orgInfo -> {
            int weight;
            try {
                weight = Integer.parseInt(orgInfo.getOrgSort());
            } catch (Exception e) {
                weight = 0;
            }
            return new TreeNode<>(orgInfo.getOrgCode(), orgInfo.getOrgParentCode(), orgInfo.getOrgName(), weight);
        }).collect(Collectors.toList());

        /*
            select * from t_org_info oi where oi.org_name = '中国铁塔'
            output: { "id": 239, "org_code": "100000", "org_name": "中国铁塔", "org_parent_code": "000000" ...}
         */
        return TreeUtil.buildSingle(treeNodes, CHINA_TOWER_ROG_CODE);
    }
}
