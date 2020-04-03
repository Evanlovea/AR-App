package com.evan.ar.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: Evan
 * @Description: 人员信息VO对象
 * @Date: Created in 15:38 2018/2/24
 * @Modified By:
 */

@Data
public class PersonInfoVO {
    @JsonProperty("name")
    private String personName;

    @JsonProperty("responsibility")
    private String personResponsibility;

    @JsonProperty("phone")
    private String personPhone;
}
