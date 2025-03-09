package com.zihenzzz.config;

import com.zihenzzz.register.api.api.RegisterFeignService;
import com.zihenzzz.register.api.entity.vo.RegisterVO;
import com.zihenzzz.register.api.result.Result;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.Date;
import java.util.function.Function;

@Configuration
public class ChatTools {
@Resource
    private RegisterFeignService registerFeignService;
@Bean
@Description("取消挂号")
public Function<CancelBookingRequest,Result<Boolean>> cancelBooking(){
    return cancelBookingRequest -> {
        registerFeignService.delete(cancelBookingRequest.register());
        return Result.ok();
    };
}

@Bean
@Description("挂号")
public Function<CancelBookingRequest,Result<Boolean>> registerBooking(){
  return request ->{
      registerFeignService.add(request.register());
      return Result.ok();
  };

}
@Bean
@Description("查询挂号")
//TODO 后期补充鉴权 如果级别高查询全部 RBAC
public Function<CancelBookingRequest,Result<RegisterVO>> selectBooking(){
    return s ->{
        Result<RegisterVO> selectList = registerFeignService.select(s.register());

        return Result.ok(selectList);
    };
}


//接收参数
// 修改记录类以包含所有必要字段
public record CancelBookingRequest(
        String patientName,
        String patientPhone,
        String patientDepartment,
        String patientDoctor,
        String patientDesease,
        String patientDesc,
        Date reservationTime
) {
    public RegisterVO register() {
        RegisterVO register = new RegisterVO();
        register.setPatientName(patientName);
        register.setPatientPhone(patientPhone);
        register.setPatientDepartment(patientDepartment);
        register.setPatientDoctor(patientDoctor);
        register.setPatientDesease(patientDesease);
        register.setPatientDesc(patientDesc);
        register.setReservationTime(reservationTime);
        register.setCreateTime(new Date());
        return register;


}
}
}
