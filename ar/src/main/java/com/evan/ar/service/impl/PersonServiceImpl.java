package com.evan.ar.service.impl;

import com.evan.ar.dataobject.PersonInfo;
import com.evan.ar.repository.PersonInfoRepository;
import com.evan.ar.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Evan
 * @Description: 关于人员信息业务层方法实现
 * @Date: Created in 21:10 2018/2/12
 * @Modified By:
 */

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonInfoRepository personInfoRepository;
    @Override
    public PersonInfo findOne(String personId) {
        return personInfoRepository.findOne(personId);
    }

    @Override
    public Page<PersonInfo> findAll(Pageable pageable) {
        return personInfoRepository.findAll(pageable);
    }

    @Override
    public PersonInfo save(PersonInfo personInfo) {
        return personInfoRepository.save(personInfo);
    }

    @Override
    public List<PersonInfo> findAllToFront() {
        return personInfoRepository.findAll();
    }

    @Override
    public List<PersonInfo> findByPersonTypeIn(List<Integer> personTypeList) {
        return personInfoRepository.findByPersonTypeIn(personTypeList);
    }
}
