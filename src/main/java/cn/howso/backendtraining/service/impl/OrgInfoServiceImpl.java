package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.howso.backendtraining.mapper.OrgInfoMapper;
import cn.howso.backendtraining.service.IOrgInfoService;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrgInfoServiceImpl extends ServiceImpl<OrgInfoMapper, OrgInfo> implements IOrgInfoService {

    private static final String CHINA_TOWER_ROG_CODE = "100000";
    private static final String ORG_TREE_KEY = "org_tree";
    private static final Jedis jedis = RedisDS.create().getJedis();
    @Override
    public Tree getOrgTree() {
        // 获取缓存
        String cacheStr = jedis.get(ORG_TREE_KEY);
        if(StrUtil.isNotBlank(cacheStr)) {
            return JSONUtil.parseObj(cacheStr).toBean(Tree.class);
        }
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

        Tree<String> tree = TreeUtil.buildSingle(treeNodes, CHINA_TOWER_ROG_CODE);
        // 添加缓存
        jedis.set(ORG_TREE_KEY, JSONUtil.toJsonStr(tree));
        return tree;
    }

    @Override
    public Tree getOrgTreeWithUser() {
        return null;
    }
}
