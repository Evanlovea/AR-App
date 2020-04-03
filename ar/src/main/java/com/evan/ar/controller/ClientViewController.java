package com.evan.ar.controller;

import com.evan.ar.VO.*;
import com.evan.ar.dataobject.LocationInfo;
import com.evan.ar.dataobject.PersonInfo;
import com.evan.ar.dataobject.ScanInfo;
import com.evan.ar.service.LocationService;
import com.evan.ar.service.PersonService;
import com.evan.ar.service.ScanService;
import com.evan.ar.utils.ResultVOUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Evan
 * @Description: 客户端用户相关
 * @Date: Created in 10:40 2018/2/13
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/client/location")
public class ClientViewController {
    @Autowired
    private ScanService scanService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private PersonService personService;
    @GetMapping("/show")
    public ResultVO list(Integer scanId){
        ScanInfoVO scanInfoVO=new ScanInfoVO();
        //1.查询所扫描的ID
        ScanInfo scanInfo=scanService.findOne(scanId);
        BeanUtils.copyProperties(scanInfo,scanInfoVO);
        //2.通过种类查询locationTypeList
        List<LocationInfo> locationInfoList=locationService.findAllToFront(scanInfo.getScanType());
        /**
         * λ表达式遍历链表
         */
//        List<Integer> personTypeList=locationInfoList.stream().map(e->e.getPersonType())
//                .collect(Collectors.toList());
        List<Integer> personTypeList=new ArrayList<>();
        for(LocationInfo locationInfo:locationInfoList){
            personTypeList.add(locationInfo.getPersonType());
        }
        //3.通过personType查询所有的人员信息
        List<PersonInfo> personInfoList=personService.findByPersonTypeIn(personTypeList);

        //4.数据拼装
        List<LocationInfoVO> locationInfoVOList=new ArrayList<>();
        //遍历locationList
        for(LocationInfo locationInfo:locationInfoList){
            LocationInfoVO locationInfoVO=new LocationInfoVO();
           /* //设置bean
            BeanUtils.copyProperties(locationInfo,locationInfoVO);*/
            locationInfoVO.setLocationId(locationInfo.getLocationId());
            locationInfoVO.setLocationName(locationInfo.getLocationName());
            locationInfoVO.setLocationLatitude(locationInfo.getLocationLatitude());
            locationInfoVO.setLocationAltitude(locationInfo.getLocationAltitude());
            locationInfoVO.setLocationLongitude(locationInfo.getLocationLongitude());
            locationInfoVO.setLocationDescription(locationInfo.getLocationDescription());
            locationInfoVO.setLocationPicture(locationInfo.getLocationPicture());
            locationInfoVO.setPanoramicLink(locationInfo.getPanoramicLink());
            List<PersonInfoVO> personInfoVOList=new ArrayList<>();
            //遍历PersonInfoList
            for(PersonInfo personInfo:personInfoList){
                if(personInfo.getPersonType().equals(locationInfo.getPersonType())){
                    PersonInfoVO personInfoVO=new PersonInfoVO();
//                    BeanUtils.copyProperties(personInfo,personInfoVO);
                    personInfoVO.setPersonName(personInfo.getPersonName());
                    personInfoVO.setPersonPhone(personInfo.getPersonPhone());
                    personInfoVO.setPersonResponsibility(personInfo.getPersonResponsibility());
                    personInfoVOList.add(personInfoVO);
                }

            }
            locationInfoVO.setPersonInfoVOList(personInfoVOList);
            locationInfoVOList.add(locationInfoVO);
        }


       /* ScanInfoVO scanInfoVO=new ScanInfoVO();
        LocationInfoVO locationInfoVO=new LocationInfoVO();
        PersonInfoVO personInfoVO=new PersonInfoVO();*/
        ResultVO resultVO=new ResultVO();
        DataVO dataVO=new DataVO();
        dataVO.setScanName(scanInfoVO.getScanName());
        dataVO.setScanType(scanInfoVO.getScanType());
        dataVO.setLocations(locationInfoVOList);
      /*
       locationInfoVO.setPersonInfoVOList(Arrays.asList(personInfoVO));
       scanInfoVO.setLocationInfoVOList(Arrays.asList(locationInfoVO));
       resultVO.setData(scanInfoVO);*/

        //resultVO.setData(scanInfoVO.getScanType()+scanInfoVO.getScanName());

//        resultVO.setData(dataVO);
//        resultVO.setData(scanInfoVO.getScanName());
       /* resultVO.setCode(0);
       resultVO.setMsg("success");*/
       return ResultVOUtil.success(dataVO);
    }
}
