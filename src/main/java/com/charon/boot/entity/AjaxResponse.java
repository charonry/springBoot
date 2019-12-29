package com.charon.boot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-28 16:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class AjaxResponse implements Serializable {
    private static final long serialVersionUID = 5660090721628131251L;
    @ApiModelProperty("是否请求成功")
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
