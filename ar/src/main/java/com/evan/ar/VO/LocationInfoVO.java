package com.evan.ar.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Evan
 * @Description: 坐标地理位置详情（前端返回）
 * @Date: Created in 15:20 2018/2/24
 * @Modified By:
 */

@Data
public class LocationInfoVO {
    /**
     * 出于安全性与代码可维护性的考虑，新建VO对象
     * 并使用
     * @JsonProperty
     * 注解，返回给前端所需要的数据
     */

    @JsonProperty("id")
    private String locationId;

    @JsonProperty("name")
    private String locationName;

    @JsonProperty("latitude")
    private BigDecimal locationLatitude;

    @JsonProperty("longitude")
    private BigDecimal locationLongitude;

    @JsonProperty("altitude")
    private BigDecimal locationAltitude;

    @JsonProperty("description")
    private String locationDescription;

    @JsonProperty("icon")
    private String locationPicture;

    @JsonProperty("link")
    private String panoramicLink;

    @JsonProperty("people")
    private List<PersonInfoVO> personInfoVOList;

}
