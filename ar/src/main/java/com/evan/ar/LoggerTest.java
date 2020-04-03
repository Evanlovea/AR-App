package com.evan.ar;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Evan
 * @Description:日志的使用
 * @Date: Created in 16:30 2018/2/1
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Data
@Slf4j
public class LoggerTest {
    @Test
    public void test1(){
        /*
            日志中信息的输出
         */
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        /*
         * 日志中变量的使用
         */
        String name="hello,world";
        String password="1234560";
        log.info("name:"+name+",password:"+password);
        log.info("name:{},password:{}",name,password);
        log.error("error...");
    }
}
