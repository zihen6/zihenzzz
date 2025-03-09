package com.zihenzzz.register.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Register)实体类
 *
 * @author makejava
 * @since 2025-02-22 10:08:28
 */
@Data
public class RegisterPO implements Serializable {
    private static final long serialVersionUID = 955389747892339319L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 患者姓名
     */
    private String patientName;
    /**
     * 患者手机号
     */
    private String patientPhone;
    /**
     * 患者预约科室
     */
    private String patientDepartment;
    /**
     * 患者预约的医生
     */
    private String patientDoctor;
    /**
     * 患者病情表述
     */
    private String patientDesease;
    /**
     * 备注
     */
    private String patientDesc;
    private Integer state;
    /**
     * 挂号创建时间
     */
    private Date createTime;
    /**
     * 预约时间
     */
    private Date reservationTime;



}

