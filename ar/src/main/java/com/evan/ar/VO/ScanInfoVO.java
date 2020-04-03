package com.evan.ar.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 扫描信息（包含扫描类型）
 * @Date: Created in 15:13 2018/2/24
 * @Modified By:
 */

@Data
public class ScanInfoVO {

    @JsonProperty("name")
    private String scanName;

    @JsonProperty("type")
    private  Integer scanType;

//    @JsonProperty("locationList")
//    private List<LocationInfoVO> locationInfoVOList;



}
