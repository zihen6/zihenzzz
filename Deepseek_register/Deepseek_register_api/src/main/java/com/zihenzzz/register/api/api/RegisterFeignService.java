package com.zihenzzz.register.api.api;

import com.zihenzzz.register.api.entity.vo.RegisterVO;
import com.zihenzzz.register.api.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("Deepseek-register")
public interface RegisterFeignService {
    //挂号操作
    @PostMapping("/register/add")
    Result<Boolean> add(@RequestBody RegisterVO register);

    //取消挂号操作
    @PostMapping("/register/delete")
    Result<Boolean> delete(@RequestBody RegisterVO registerVO);

    //查询挂号操作
    @PostMapping("/register/select")
    Result<RegisterVO> select(@RequestBody RegisterVO register);
}
