package com.evan.ar.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Evan
 * @Description: json拼装返回data的数据
 * @Date: Created in 15:33 2018/2/28
 * @Modified By:
 */

@Data
public class DataVO<T> {
    @JsonProperty("name")
    private  String scanName;

    @JsonProperty("type")
    private Integer scanType;

    @JsonProperty("locations")
    private T locations;
}
