package com.evan.ar.VO;

import lombok.Data;

/**
 * @Author: Evan
 * @Description: http请求返回的最外层对象
 * @Date: Created in 10:54 2018/2/13
 * @Modified By:
 */

@Data
public class ResultVO<T>{
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private  String msg;
    /**
     * 具体内容
     */
    private T data;
}
