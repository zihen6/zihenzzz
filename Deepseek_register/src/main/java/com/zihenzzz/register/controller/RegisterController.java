package com.zihenzzz.register.controller;


import com.google.common.base.Preconditions;
import com.zihenzzz.register.entity.Register;
import com.zihenzzz.register.result.Result;
import com.zihenzzz.register.service.RegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * (Register)表控制层
 *
 * @author makejava
 * @since 2025-02-22 10:08:26
 */
@Slf4j
@RestController
@RequestMapping("register")
public class RegisterController {
    /**
     * 服务对象
     */
    @Resource
    private RegisterService registerService;
@PostMapping("/add")
public Result add(@RequestBody Register register){
    try {
        log.info("register.add:{}",register);
        Preconditions.checkNotNull(register.getPatientName(),"患者姓名不能为空");
        registerService.insert(register);
        return Result.ok();
    } catch (Exception e) {
        log.error("register.add:{}",e.getMessage(),e);
       return Result.fail("新增数据失败");
    }
}


}

