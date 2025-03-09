package com.zihenzzz.register.convert;

import com.zihenzzz.register.api.entity.vo.RegisterVO;
import com.zihenzzz.register.entity.po.RegisterPO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T17:00:18+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class RegisterVOConvertImpl implements RegisterVOConvert {

    @Override
    public RegisterPO RegisterVOTOPO(RegisterVO registerVO) {
        if ( registerVO == null ) {
            return null;
        }

        RegisterPO registerPO = new RegisterPO();

        registerPO.setId( registerVO.getId() );
        registerPO.setPatientName( registerVO.getPatientName() );
        registerPO.setPatientPhone( registerVO.getPatientPhone() );
        registerPO.setPatientDepartment( registerVO.getPatientDepartment() );
        registerPO.setPatientDoctor( registerVO.getPatientDoctor() );
        registerPO.setPatientDesease( registerVO.getPatientDesease() );
        registerPO.setPatientDesc( registerVO.getPatientDesc() );
        registerPO.setState( registerVO.getState() );
        registerPO.setCreateTime( registerVO.getCreateTime() );
        registerPO.setReservationTime( registerVO.getReservationTime() );

        return registerPO;
    }

    @Override
    public RegisterVO RegisterPOTOVO(RegisterPO registerPO) {
        if ( registerPO == null ) {
            return null;
        }

        RegisterVO registerVO = new RegisterVO();

        registerVO.setId( registerPO.getId() );
        registerVO.setPatientName( registerPO.getPatientName() );
        registerVO.setPatientPhone( registerPO.getPatientPhone() );
        registerVO.setPatientDepartment( registerPO.getPatientDepartment() );
        registerVO.setPatientDoctor( registerPO.getPatientDoctor() );
        registerVO.setPatientDesease( registerPO.getPatientDesease() );
        registerVO.setPatientDesc( registerPO.getPatientDesc() );
        registerVO.setState( registerPO.getState() );
        registerVO.setCreateTime( registerPO.getCreateTime() );
        registerVO.setReservationTime( registerPO.getReservationTime() );

        return registerVO;
    }
}
