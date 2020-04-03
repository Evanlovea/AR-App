package com.evan.ar.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: Evan
 * @Description: 人员属性信息
 * @Date: Created in 18:25 2018/2/12
 * @Modified By:
 */

@Data
@Entity
@DynamicUpdate
public class PersonInfo {
    @Id
    //@GeneratedValue
    private String personId;
    /**
     * 所在的位置
     */
    private Integer personType;
    /**
     * 姓名
     */
    private  String personName;
    /**
     * 年龄
     */
    private  Integer personAge;
    /**
     * 性别
     */
    private String personSex;
    //职责
    private String personResponsibility;
    //联系方式
    private String personPhone;

}
