package com.ar.evan.arnavigation.model;
import android.location.Location;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 定义location位置，将一个GPS坐标点设置属性信息
 */
@Data

public class ARPoint {
    Location location;
    String name;



    /**
     * @Description 实例化ARPoint
     * @param name
     * @param lat
     * @param lon
     * @param altitude
     */
    public ARPoint(String name, double lat, double lon, double altitude) {
        this.name = name;
        location = new Location("ARPoint");
        location.setLatitude(lat);
        location.setLongitude(lon);
        location.setAltitude(altitude);
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
