package com.evan.ar.service;

import com.evan.ar.dataobject.LocationInfo;
import com.evan.ar.dataobject.PersonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 关于人员的业务逻辑操作接口
 * @Date: Created in 19:10 2018/2/12
 * @Modified By:
 */


public interface PersonService {
    /**
     * 通过person_id进行查找
     */
    PersonInfo findOne(String personId);

    /**
     * 查找全部的person
     */
    Page<PersonInfo> findAll(Pageable pageable);
    /**
     * 增加/更新信息
     */
    PersonInfo save(PersonInfo personInfo);

    /**
     * 查找全部的person（只进行List查找，不进行分页）
     * @Destination 主要是为了反馈给前端数据
     */
    List<PersonInfo> findAllToFront();

    /**
     * 通过personTypeList进行personInfo的查找
     * @param personTypeList
     * @return
     */
    List<PersonInfo> findByPersonTypeIn(List<Integer> personTypeList);

}
