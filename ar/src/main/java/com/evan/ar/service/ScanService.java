package com.evan.ar.service;

import com.evan.ar.dataobject.ScanInfo;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 扫码信息service层接口
 * @Date: Created in 14:42 2018/2/12
 * @Modified By:
 */


public interface ScanService {
    //通过scan_id查询
    ScanInfo findOne(Integer scanId);
    //查询所有
    List<ScanInfo> findAll();
    //通过scan_type查询链表
    List<ScanInfo> findByScanTypeIn(List<Integer> scanTypeList);
    //增加和更新
    ScanInfo save(ScanInfo scanInfo);
}
