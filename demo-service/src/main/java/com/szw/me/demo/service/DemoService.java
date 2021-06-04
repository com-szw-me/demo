package com.szw.me.demo.service;

import com.szw.me.demo.req.AddDemoReq;
import com.szw.me.demo.req.EditDemoReq;
import com.szw.me.framework.vo.ResultVO;

public interface DemoService {
    ResultVO add(AddDemoReq req);
    ResultVO edit(EditDemoReq req);
    ResultVO get(Integer id);
    ResultVO delete(Integer id);
}
