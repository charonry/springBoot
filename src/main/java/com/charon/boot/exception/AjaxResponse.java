package com.charon.boot.exception;

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
@ApiModel
public class AjaxResponse implements Serializable {
    private static final long serialVersionUID = 5660090721628131251L;
    // ajax请求是否成功
    private boolean isok;
    // http status code
    private int code;
    // 请求失败的的提示信息。
    private String message;
    // 请求成功时，需要响应给前端的数据
    private Object data;

    private AjaxResponse() {

    }

    /**
     * 请求出现异常时的响应数据封装
     *
     * @param e
     * @return
     */
    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员QQ：1178807730进行处理!");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员QQ：1178807730进行处理!");
        }
        return resultBean;
    }


    /**
     *  请求成功时的响应数据封装，没有响应数据（比如删除修改成功）
     *
     * @return
     */
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }



    /**
     * 请求成功时的响应数据封装，有响应数据（比如查询成功）
     *
     * @param data
     * @return
     */
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
