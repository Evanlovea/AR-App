package com.evan.ar.repository;

import com.evan.ar.dataobject.ScanInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description: DAO层单元测试
 * @Date: Created in 11:19 2018/2/12
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScanInfoRepositoryTest {
    @Autowired
    private  ScanInfoRepository scanInfoRepository;

    /**
     * 对一种区域种类进行查找测试
     */
    @Test
    public void findOneTest(){
        ScanInfo scanInfo=scanInfoRepository.findOne(1);
        System.out.println(scanInfo.toString());
    }
    /**
     * 添加方法测试
     */
    @Test
    @Transactional
    //此注解用于清除测试例子
    public void saveTest(){
        ScanInfo scanInfo=new ScanInfo("黎阳路",5);
      /*  scanInfo.setScanName("qinglong");
        scanInfo.setScanType(4);*/
      ScanInfo result=scanInfoRepository.save(scanInfo);
        Assert.assertNotNull(result);
       // scanInfoRepository.save(scanInfo);
    }
    @Test
   public void findByScanTypeInTest(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<ScanInfo> result=scanInfoRepository.findByScanTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}