package com.ar.evan.arnavigation.helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @Description FastJson解析工具类
 * Created by Evan on 2018/3/4.
 */

public class FAST {
        /**
         * 解析JsonObject数据
         *
         * @param jsonString
         *            Json格式字符串
         * @param cls
         *            封装类
         *
         */
        public static <T> T parseObject(String jsonString, Class<T> cls) {
            T t = null;
            try {
                t = JSON.parseObject(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }

        /**
         * 解析JsonArray数据
         *
         * @param jsonString
         * @param cls
         * @return
         */
        public static <T> List<T> parseArray(String jsonString, Class<T> cls) {
            List<T> list = new ArrayList<T>();
            try {
                list = JSON.parseArray(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        /**
         * 解析JsonArray数据，返回Map类型的List
         *
         * @param jsonString
         * @return
         */
        public static List<Map<String, Object>> parseObjectListKeyMaps(
                String jsonString) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            try {
                list = JSON.parseObject(jsonString,
                        new TypeReference<List<Map<String, Object>>>() {
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
    }

