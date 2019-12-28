package com.charon.boot.entity;

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
public class AjaxResponse implements Serializable {
    private static final long serialVersionUID = 5660090721628131251L;
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
