package com.evan.ar.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: Evan
 * @Description: 位置相关对象信息
 * @Date: Created in 15:37 2018/2/12
 * @Modified By:
 */
@Entity
//动态更新时间
@DynamicUpdate
@Data

public class LocationInfo {
    //location_id
    @Id
    private String locationId;
    //名字
    private  String locationName;
    //经度
    private BigDecimal locationLatitude;
    //纬度
    private BigDecimal locationLongitude;
    //高度
    private  BigDecimal locationAltitude;
    //描述
    private String locationDescription;
    //图片链接
    private  String locationPicture;
    //全景外链
    private  String panoramicLink;
    //扫描种类
    private  Integer scanType;
    //人员种类
    private  Integer personType;
}
