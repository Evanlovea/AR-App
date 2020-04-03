package com.ar.evan.arnavigation.model;

import java.util.List;

import lombok.Data;

/**
 * Created by Evan on 2018/3/4.
 */
@Data
public class LocationListVO {
    /**
     * id : 123456
     * name : 丹尼斯
     * latitude : 12.335
     * longitude : 34.225
     * altitude : 5.2
     * description : 一个购物的地方
     * icon : http://www.dennis.com.cn/u/cms/www/201707/191157482x37.jpg
     * link : http://122.114.223.188/toShow?VRourEditor=206
     * people : [{"name":"jack","responsibility":"doctor","phone":"13253312194"},{"name":"evan","responsibility":"护士","phone":"13565667488"}]
     *
     */

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double altitude;
    private String description;
    private String icon;
    private String link;

    private String people;


}
