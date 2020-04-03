package com.evan.ar.service.impl;

import com.evan.ar.dataobject.LocationInfo;
import com.evan.ar.service.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 17:22 2018/2/12
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceImplTest {
    @Autowired
    private  LocationServiceImpl locationService;

    @Test
    public void findOne() throws Exception{
        LocationInfo locationInfo= locationService.findOne("122");
        Assert.assertEquals("122",locationInfo.getLocationId());
    }

    @Test
    public void findAll() throws Exception{
        /**
         * 构造Pageable对象
         */
        PageRequest request=new PageRequest(0,2);
        Page<LocationInfo> locationInfoPage=locationService.findAll(request);
       System.out.println(locationInfoPage.getTotalElements());
       Assert.assertNotEquals(0,locationInfoPage.getTotalElements());
    }
    @Transactional
    @Test
    public void save() throws  Exception{
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
        LocationInfo result=locationService.save(locationInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByPersonTypeIn() {
        /**
         * 通过person_type进行查找
         */
      List<LocationInfo> locationInfoList=locationService.findByPersonTypeIn(Arrays.asList(1,2,3));
      Assert.assertNotEquals(0,locationInfoList.size());
    }
}