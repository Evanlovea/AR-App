package com.evan.ar.repository;

import com.evan.ar.dataobject.ScanInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Evan
 * @Description:扫描信息DAO层
 * @Date: Created in 11:14 2018/2/12
 * @Modified By:
 */

/**
 * DAO层接口，使用JPA进行数据库交互
 */
public interface ScanInfoRepository extends JpaRepository<ScanInfo,Integer>{
    /**
     * 通过scanTypeList查找（后端）
     */
   List<ScanInfo> findByScanTypeIn(List<Integer> scanTypeList);
    /**
     * 通过scanID查询scanType（前端）
     */
     ScanInfo findByScanIdIn(Integer scanId);

}
