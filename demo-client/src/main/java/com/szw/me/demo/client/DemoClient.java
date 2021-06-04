package com.szw.me.demo.client;

import com.szw.me.framework.feign.FeignConfiguration;
import com.szw.me.framework.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "demo", configuration = {FeignConfiguration.class})
@RequestMapping("/demo")
public interface DemoClient {

    @GetMapping("/{id}")
    ResultVO get(@PathVariable("id") Integer id);
}
