package com.szw.me.demo.service.impl;

import com.szw.me.demo.domain.Demo;
import com.szw.me.demo.enums.DemoResultEnum;
import com.szw.me.demo.exception.DemoException;
import com.szw.me.demo.mapper.DemoMapper;
import com.szw.me.demo.req.AddDemoReq;
import com.szw.me.demo.req.EditDemoReq;
import com.szw.me.demo.service.DemoService;
import com.szw.me.framework.util.ResultVOUtil;
import com.szw.me.framework.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO add(AddDemoReq req) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(req, demo);
        demoMapper.insert(demo);
        return ResultVOUtil.success(demo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO edit(EditDemoReq req) {
        Demo demo = demoMapper.selectByPrimaryKey(req.getId());
        if (demo == null) {
            throw new DemoException(DemoResultEnum.NOT_FOUND);
        }
        BeanUtils.copyProperties(req, demo);
        demoMapper.updateByPrimaryKey(demo);
        return ResultVOUtil.success(demo);
    }

    @Override
    public ResultVO get(Integer id) {
        Demo demo = demoMapper.selectByPrimaryKey(id);
        return ResultVOUtil.success(demo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO delete(Integer id) {
        demoMapper.deleteByPrimaryKey(id);
        return ResultVOUtil.success();
    }
}
