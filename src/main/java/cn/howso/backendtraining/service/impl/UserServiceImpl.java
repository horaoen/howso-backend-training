package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.User;
import cn.howso.backendtraining.mapper.UserMapper;
import cn.howso.backendtraining.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Map<String, List<User>> getUserGroupByOrgCode() {
        return this.list()
                .stream()
                .collect(Collectors.groupingBy(User::getOrgCode));
    }
}
