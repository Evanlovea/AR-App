package com.evan.ar.service.impl;

import com.evan.ar.dataobject.ScanInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description:Service层实现单元测试
 * @Date: Created in 15:08 2018/2/12
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ScanServiceImplTest {
    @Autowired
    private ScanServiceImpl scanService;

    @Test
    public void findOne() {
        /**
         * 通过scan_id查找一个扫描信息
         */
        ScanInfo scanInfo=scanService.findOne(1);
        //断言测试是否相等
        Assert.assertEquals(new Integer(1),scanInfo);
        System.out.println(scanInfo.getScanName());
    }

    @Test
    public void findAll() {
        /**
         * 查询所有的扫描信息（主要用于后端管理系统实现）
         */
        List<ScanInfo> scanInfoList=scanService.findAll();
        //只要查询不为0则表示成功
        Assert.assertNotEquals(0,scanInfoList.size());
    }

    @Test
    public void findByScanTypeIn() throws  Exception{
        /**
         * 通过扫描分类进行查找
         */
        List<ScanInfo> scanInfoList=scanService.findByScanTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,scanInfoList.size());
    }

    @Test
    public void save() {
        /**
         * 更新和添加测试（后端）
         */
        ScanInfo scanInfo=new ScanInfo("立交桥",6);
        ScanInfo result=scanService.save(scanInfo);
        /**
         * test whether the result is null
         */
        Assert.assertNotNull(result);
    }
}