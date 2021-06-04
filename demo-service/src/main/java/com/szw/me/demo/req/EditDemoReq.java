package com.szw.me.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("编辑请求")
public class EditDemoReq {

    @ApiModelProperty("ID")
    @NotNull(message = "请给出ID")
    @Min(value = 1, message = "请给出合理ID")
    private Integer id;

    @ApiModelProperty("姓名")
    @NotBlank(message = "请给出姓名")
    private String name;
}
