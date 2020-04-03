package com.evan.ar.service.impl;

import com.evan.ar.dataobject.LocationInfo;
import com.evan.ar.repository.LocationInfoRepository;
import com.evan.ar.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 位置相关service操作
 * @Date: Created in 17:05 2018/2/12
 * @Modified By:
 */

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationInfoRepository locationInfoRepository;
    @Override
    public LocationInfo findOne(String locationId) {
        return locationInfoRepository.findOne(locationId);
    }

    @Override
    public Page<LocationInfo> findAll(Pageable pageable) {
        return locationInfoRepository.findAll(pageable);
    }

    @Override
    public LocationInfo save(LocationInfo locationInfo) {
        return locationInfoRepository.save(locationInfo);
    }

    @Override
    public List<LocationInfo> findByPersonTypeIn(List<Integer> personTypeList) {
        return locationInfoRepository.findByPersonTypeIn(personTypeList);
    }

    @Override
    public List<LocationInfo> findAllToFront(Integer scanType) {
        return locationInfoRepository.findByScanType(scanType);
    }


}
