package com.evan.ar.repository;

import com.evan.ar.dataobject.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 18:55 2018/2/12
 * @Modified By:
 */


public interface PersonInfoRepository extends JpaRepository<PersonInfo,String>{
    /**
     * 通过人员姓名进行查找
     * @param personName
     * @return
     */
    List<PersonInfo>findByPersonName(String personName);

    /**
     *
     * @param personTypeList
     * @return
     */
    List<PersonInfo> findByPersonTypeIn(List<Integer> personTypeList);


}
