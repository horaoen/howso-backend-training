package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.User;
import cn.howso.backendtraining.mapper.UserMapper;
import cn.howso.backendtraining.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author horaoen
 * @since 2023-06-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}