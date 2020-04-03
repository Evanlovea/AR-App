package com.evan.ar.service.impl;

import com.evan.ar.dataobject.ScanInfo;
import com.evan.ar.repository.ScanInfoRepository;
import com.evan.ar.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 扫码信息service层实现
 * @Date: Created in 14:55 2018/2/12
 * @Modified By:
 */
//service层需要加此注解
@Service
public class ScanServiceImpl implements ScanService{
    @Autowired
    private ScanInfoRepository scanInfoRepository;
    @Override
    public ScanInfo findOne(Integer scanId) {
        return scanInfoRepository.findOne(scanId);
    }

    @Override
    public List<ScanInfo> findAll() {
        return scanInfoRepository.findAll();
    }

    @Override
    public List<ScanInfo> findByScanTypeIn(List<Integer> scanTypeList) {
        return scanInfoRepository.findByScanTypeIn(scanTypeList);
    }

    @Override
    public ScanInfo save(ScanInfo scanInfo) {
        return scanInfoRepository.save(scanInfo);
    }
}
