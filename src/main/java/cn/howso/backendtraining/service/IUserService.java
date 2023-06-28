package cn.howso.backendtraining.service;

import cn.howso.backendtraining.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IUserService extends IService<User> {
    /**
     * 获取以orgCode区分的用户组map
     */
    Map<String, List<User>> getUserGroupByOrgCode();
}
