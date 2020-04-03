package com.ar.evan.arnavigation.model;

import java.io.Serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Evan on 2018/3/2.
 */
@Data

public class LocationInfoBean implements Serializable {
    private  String locationName;
    private double latitude;
    private double longitude;
    private double altitude;
}
