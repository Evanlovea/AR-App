package com.ar.evan.arnavigation.model;

import java.util.List;

import lombok.Data;

/**
 * Created by Evan on 2018/3/4.
 */
@Data
public class DataVO {
    /**
     * name : 黄河路
     * type : 1
     * locationList : [{"id":"123456","name":"丹尼斯","latitude":12.335,"longitude":34.225,"altitude":5.2,"description":"一个购物的地方","icon":"http://www.dennis.com.cn/u/cms/www/201707/191157482x37.jpg","link":"http://122.114.223.188/toShow?VRourEditor=206","people":[{"name":"jack","responsibility":"doctor","phone":"13253312194"},{"name":"evan","responsibility":"护士","phone":"13565667488"}]},{"id":"123457","name":"微阿科技","latitude":44.123,"longtitude":33.124,"altitude":5.2,"description":"公司","icon":"http://www.dennis.com.cn/u/cms/www/201707/191157482x37.jpg","link":"http://122.114.223.188/toShow?VRourEditor=206","people":[{"name":"linda","responsibility":"doctor","phone":"1325355555"},{"name":"tim","responsibility":"护士","phone":"13561125488"}]}]
     */

    private String name;
    private int type;
    private String locations;

}
