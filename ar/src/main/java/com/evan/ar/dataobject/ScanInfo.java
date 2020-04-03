package com.evan.ar.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: Evan
 * @Description: 二维码扫描所在类型信息（将用户所在的地域进行分类贴码）
 * @Date: Created in 11:06 2018/2/12
 * @Modified By:
 */
@Data
//动态更新时间
@DynamicUpdate
@Entity
/*
   类名需要和数据库表名一致，类名为驼峰型，表名为下划线
 */
public class ScanInfo {
    /**
     * 二维码信息ID(primary key)
     */
      /*通过annotation来映射hibernate实体的,
    基于annotation的hibernate主键标识为@Id, */
    @Id
    @GeneratedValue
    private  Integer scanId;
    //二维码信息的名称
    private  String scanName;
    //二维码信息所在区域的种类
    private Integer scanType;
    /**
     * 构造方法
     */
    public ScanInfo(){

    }
    public ScanInfo(String scanName,Integer scanType){
        this.scanName=scanName;
        this.scanType=scanType;
    }

}
