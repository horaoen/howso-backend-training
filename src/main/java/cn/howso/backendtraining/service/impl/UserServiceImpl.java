package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.User;
import cn.howso.backendtraining.mapper.UserMapper;
import cn.howso.backendtraining.service.IUserService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final String ALL_USER_KEY = "all_user";
    private static final Jedis jedis = RedisDS.create().getJedis();
    
    @Override
    public Map<String, List<User>> getUserGroupByOrgCode() {
        //获取用户缓存
        String cacheStr = jedis.get(ALL_USER_KEY);
        List<User> users;
        if(StrUtil.isNotBlank(cacheStr)) {
            users = JSONUtil.toList(cacheStr, User.class);
        } else {
            users = this.list();
            jedis.set(ALL_USER_KEY, JSONUtil.toJsonStr(users));
        }
        return users.stream().collect(Collectors.groupingBy(User::getOrgCode));
    }
}
