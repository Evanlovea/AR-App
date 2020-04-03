package com.evan.ar.utils;

import com.evan.ar.VO.ResultVO;

/**
 * @Author: Evan
 * @Description: 返回结果工具类
 * @Date: Created in 15:43 2018/2/28
 * @Modified By:
 */


public class ResultVOUtil {
    /**
     * 返回数据成功时
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * 当无参数传递时
     */
    public static ResultVO success(){
        return success(null);
    }
    /**
     * 当出现错误时
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
