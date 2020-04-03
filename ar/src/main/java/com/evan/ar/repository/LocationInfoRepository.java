package com.evan.ar.repository;
import com.evan.ar.dataobject.LocationInfo;
import com.evan.ar.dataobject.ScanInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 位置DAO层实现
 * @Date: Created in 15:52 2018/2/12
 * @Modified By:
 */



public interface LocationInfoRepository extends JpaRepository<LocationInfo,String>{
    //通过人员种类进行查找
    List<LocationInfo> findByPersonTypeIn(List<Integer> personTypeList);

    /**
     * 通过扫码查询
     * @param scanType
     * @return
     */
    List<LocationInfo> findByScanType(Integer scanType);

}
