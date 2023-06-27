package cn.howso.backendtraining.service.impl;

import cn.howso.backendtraining.entity.OrgInfo;
import cn.howso.backendtraining.mapper.OrgInfoMapper;
import cn.howso.backendtraining.service.IOrgInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrgInfoServiceImpl extends ServiceImpl<OrgInfoMapper, OrgInfo> implements IOrgInfoService {

}
