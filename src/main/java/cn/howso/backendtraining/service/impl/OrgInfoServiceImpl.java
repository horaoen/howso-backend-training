package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.howso.backendtraining.entity.User;
import cn.howso.backendtraining.mapper.OrgInfoMapper;
import cn.howso.backendtraining.service.IOrgInfoService;
import cn.howso.backendtraining.service.IUserService;
import cn.hutool.core.lang.TypeReference;
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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * org_tree 缓存反序列化后是个无范型Tree对象难以递归塞值(每个部门的user)
 * 所以选择将所有部门加入缓存, 所有方法获取部门通过 {@link #buildOrgTreeNodes()}
 */
@Service
public class OrgInfoServiceImpl extends ServiceImpl<OrgInfoMapper, OrgInfo> implements IOrgInfoService {

    private static final String CHINA_TOWER_ORG_CODE = "100000";
    private static final String ORG_TREE_KEY = "org_tree";
    private static final String ORG_INFOS_KEY = "org_infos";
    private static final String ORG_TREE_WITH_USER_KEY = "org_tree_with_user";
    private static final Jedis jedis = RedisDS.create().getJedis();

    private final IUserService userService;

    public OrgInfoServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Tree<String> getOrgTree() {
        // 获取缓存
        String cacheStr = jedis.get(ORG_TREE_KEY);
        if (StrUtil.isNotBlank(cacheStr)) {
            return JSONUtil
                    .parseObj(cacheStr)
                    .toBean(new TypeReference<Tree<String>>() {
                    });
        }

        List<TreeNode<String>> treeNodes = buildOrgTreeNodes();

        Tree<String> tree = TreeUtil.buildSingle(treeNodes, CHINA_TOWER_ORG_CODE);
        // 添加缓存
        jedis.set(ORG_TREE_KEY, JSONUtil.toJsonStr(tree));
        return tree;
    }

    /**
     * 对部门分别查询其用户会频繁访问数据库存在性能问题
     * 将所有部门org_code和对应的users一次性预处理成map, 见 {@link IUserService#getUserGroupByOrgCode()}
     */
    @Override
    public Tree<String> getOrgTreeWithUser() {
        String cacheStr = jedis.get(ORG_TREE_WITH_USER_KEY);
        if (StrUtil.isNotBlank(cacheStr)) {
            return JSONUtil.parseObj(cacheStr).toBean(new TypeReference<Tree<String>>() {
            });
        }

        Map<String, List<User>> userMap = userService.getUserGroupByOrgCode();
        List<TreeNode<String>> treeNodes = this.buildOrgTreeNodes();
        Tree<String> tree = TreeUtil.buildSingle(treeNodes, CHINA_TOWER_ORG_CODE);
        tree.walk(child -> {
            if (!child.hasChild()) {
                child.putExtra("users", userMap.get(child.getId()));
            }
        });
        jedis.set(ORG_TREE_WITH_USER_KEY, JSONUtil.toJsonStr(tree));
        return tree;
    }

    private List<TreeNode<String>> buildOrgTreeNodes() {
        // 获取缓存
        String cacheStr = jedis.get(ORG_INFOS_KEY);
        List<OrgInfo> orgInfos;
        if (StrUtil.isNotBlank(cacheStr)) {
            orgInfos = JSONUtil.toList(cacheStr, OrgInfo.class);
        } else {
            orgInfos = this.list();
            jedis.set(ORG_INFOS_KEY, JSONUtil.toJsonStr(orgInfos));
        }
        
        /*
            构建所有部门treeNodes
            select * from t_org_info oi where oi.org_name = '中国铁塔'
            output: { "id": 239, "org_code": "100000", "org_name": "中国铁塔", "org_parent_code": "000000" ...}
         */
        return orgInfos.stream().map(orgInfo -> {
            int weight;
            try {
                weight = Integer.parseInt(orgInfo.getOrgSort());
            } catch (Exception e) {
                weight = 0;
            }
            return new TreeNode<>(orgInfo.getOrgCode(), orgInfo.getOrgParentCode(), orgInfo.getOrgName(), weight);
        }).collect(Collectors.toList());
    }
}
