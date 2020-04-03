package com.evan.ar.repository;

import com.evan.ar.dataobject.LocationInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 16:03 2018/2/12
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LocationInfoRepositoryTest {
    @Autowired
    private LocationInfoRepository locationInfoRepository;
    @Test
    public void saveTest(){
        LocationInfo locationInfo=new LocationInfo();
        locationInfo.setLocationId("122");
        locationInfo.setLocationName("丹尼斯");
        locationInfo.setLocationLatitude(new BigDecimal(33.22));
        locationInfo.setLocationLongitude(new BigDecimal(141.1));;
        locationInfo.setLocationAltitude(new BigDecimal(11));
        locationInfo.setLocationDescription("购物的地方");
        locationInfo.setLocationPicture("http://img2.manshijian.com/upload/member/image/68193/969f13ffea9a9e95ebb64197b365c1c9.jpg");
        locationInfo.setPanoramicLink("http://baidu.com");
        locationInfo.setPersonType(1);
        locationInfo.setScanType(4);
        locationInfoRepository.save(locationInfo);
    }
 /*   @Test
    public void findByPersonTypeInTest() {
        List<Integer> list= Arrays.asList(1,2,3);
        List<LocationInfo> result=LocationInfoRepository.findByPersonTypeIn();
    }*/
}