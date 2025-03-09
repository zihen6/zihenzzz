package com.zihenzzz.register.convert;

import com.zihenzzz.register.api.entity.vo.RegisterVO;
import com.zihenzzz.register.entity.po.RegisterPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterVOConvert {
    RegisterVOConvert INSTANCE = Mappers.getMapper(RegisterVOConvert.class);

    RegisterPO RegisterVOTOPO (RegisterVO registerVO);
    RegisterVO RegisterPOTOVO(RegisterPO registerPO);
}
