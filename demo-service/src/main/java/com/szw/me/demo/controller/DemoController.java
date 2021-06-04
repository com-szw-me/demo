package com.szw.me.demo.controller;

import com.szw.me.demo.req.AddDemoReq;
import com.szw.me.demo.req.EditDemoReq;
import com.szw.me.demo.service.DemoService;
import com.szw.me.framework.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping
    @ApiOperation("新增数据")
    public ResultVO add(@Validated @RequestBody AddDemoReq req) {
        return demoService.add(req);
    }

    @PutMapping
    @ApiOperation("修改数据")
    public ResultVO edit(@Validated @RequestBody EditDemoReq req) {
        return demoService.edit(req);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取数据")
    public ResultVO get(@PathVariable("id") Integer id) {
        return demoService.get(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除数据")
    public ResultVO delete(@PathVariable("id") Integer id) {
        return demoService.delete(id);
    }
}
