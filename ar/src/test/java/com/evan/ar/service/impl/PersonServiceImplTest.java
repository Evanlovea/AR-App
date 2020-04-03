package com.evan.ar.service.impl;

import com.evan.ar.dataobject.PersonInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description: 人员信息业务层接口实现测试
 * @Date: Created in 21:16 2018/2/12
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceImplTest {
    @Autowired
    PersonServiceImpl personService;
    @Test
    public void findOne() throws Exception{
        PersonInfo personInfo=personService.findOne("1");
        Assert.assertEquals("1",personInfo.getPersonId());
    }

    @Test
    public void findAll() throws  Exception{
        PageRequest request=new PageRequest(0,2);
        Page<PersonInfo> personInfoPage=personService.findAll(request);
        System.out.println(personInfoPage.getTotalElements());
        Assert.assertNotEquals(0,personInfoPage.getTotalElements());
    }
    @Test
    public  void findByPersonTypeIn() throws Exception{
        List<Integer> personTypeList=new ArrayList<>(Arrays.asList(1,2));
        List<PersonInfo> personInfoList=personService.findByPersonTypeIn(personTypeList);
        System.out.println(personInfoList);
        Assert.assertNotEquals(0,personInfoList.size());
    }

    @Test
    public void save() throws Exception{
        PersonInfo personInfo=new PersonInfo();
        personInfo.setPersonId("1");
        personInfo.setPersonType(1);
        personInfo.setPersonName("evan");
        personInfo.setPersonAge(22);
        personInfo.setPersonSex("男");
        personInfo.setPersonResponsibility("店主");
        personInfo.setPersonPhone("13253312184");
        PersonInfo result=personService.save(personInfo);
        Assert.assertNotNull(result);
    }
}