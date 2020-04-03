package com.ar.evan.arnavigation.model;

import java.util.List;

/**
 * Created by Evan on 2018/3/2.
 */
public class ResultBean{

    /**
     * code : 0
     * msg : success
     * data : {"name":"黄河路","type":1,"locationList":[{"id":"123456","name":"丹尼斯","latitude":12.335,"longitude":34.225,"altitude":5.2,"description":"一个购物的地方","icon":"http://www.dennis.com.cn/u/cms/www/201707/191157482x37.jpg","link":"http://122.114.223.188/toShow?VRourEditor=206","people":[{"name":"jack","responsibility":"doctor","phone":"13253312194"},{"name":"evan","responsibility":"护士","phone":"13565667488"}]},{"id":"123457","name":"微阿科技","latitude":44.123,"longtitude":33.124,"altitude":5.2,"description":"公司","icon":"http://www.dennis.com.cn/u/cms/www/201707/191157482x37.jpg","link":"http://122.114.223.188/toShow?VRourEditor=206","people":[{"name":"linda","responsibility":"doctor","phone":"1325355555"},{"name":"tim","responsibility":"护士","phone":"13561125488"}]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        public static class LocationListBean {


            public static class PeopleBean {
                /**
                 * name : jack
                 * responsibility : doctor
                 * phone : 13253312194
                 */

                private String name;
                private String responsibility;
                private String phone;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getResponsibility() {
                    return responsibility;
                }

                public void setResponsibility(String responsibility) {
                    this.responsibility = responsibility;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }
            }
        }
    }
}

