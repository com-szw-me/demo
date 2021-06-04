package com.szw.me.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("添加请求")
public class AddDemoReq {

    @ApiModelProperty("姓名")
    @NotBlank(message = "请给出姓名")
    private String name;
}
