package com.evan.ar.service;

import com.evan.ar.dataobject.LocationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 位置service层接口
 * @Date: Created in 16:55 2018/2/12
 * @Modified By:
 */


public interface LocationService {
    /**
     * 按照location_id进行查询（后端）
     * @param locationId
     * @return
     */
    LocationInfo findOne(String locationId);

    /**
     * 查找所有的位置（后端）
     * @param pageable
     * @return
     */
    Page<LocationInfo> findAll(Pageable pageable);

    /**
     * 增加或者更新位置（后端）
     * @param locationInfo
     * @return
     */
    LocationInfo save(LocationInfo locationInfo);

    /**
     * 通过person_type进行查找
     * @param personTypeList
     * @return
     */
    List<LocationInfo> findByPersonTypeIn(List<Integer> personTypeList);

    /**
     * 查询所有位置节点返回给前端
     * @return
     */
    List<LocationInfo>findAllToFront(Integer scanType);
}
