package com.jxxy.mlxc.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.service.GrabSimgleService;
import com.jxxy.mlxc.business.mapper.GrabSimgleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Project:mlxc-parent
 * @Class:GrabSimgleServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日10:39
 * @Description:秒杀
 * @Version: 1.0.0
 */
@Service(version="1.0.0",interfaceClass= GrabSimgleService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class GrabSimgleServiceImpl implements GrabSimgleService {
    @Autowired
    private GrabSimgleDao grabSimgleDao;
    @Override
    public void insert(GrabSimgleDto dto) {
        grabSimgleDao.insert(dto);
    }

    @Override
    public void update(GrabSimgleDto dto) {
        grabSimgleDao.update(dto);
    }

    @Override
    public GrabSimgleDto getGrabSimgle() {
        return grabSimgleDao.getGrabSimgle();
    }
}
