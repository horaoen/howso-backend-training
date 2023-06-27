package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.howso.backendtraining.mapper.OrgInfoMapper;
import cn.howso.backendtraining.service.IOrgInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author horaoen
 * @since 2023-06-27
 */
@Service
public class OrgInfoServiceImpl extends ServiceImpl<OrgInfoMapper, OrgInfo> implements IOrgInfoService {

}
