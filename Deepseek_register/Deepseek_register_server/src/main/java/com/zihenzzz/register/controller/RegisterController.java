package com.zihenzzz.register.controller;


import com.google.common.base.Preconditions;
import com.zihenzzz.register.api.entity.vo.RegisterVO;
import com.zihenzzz.register.api.result.Result;
import com.zihenzzz.register.convert.RegisterVOConvert;
import com.zihenzzz.register.entity.po.RegisterPO;
import com.zihenzzz.register.service.RegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
public Result<Boolean> add(@RequestBody RegisterVO register){
    try {
        log.info("register.add:{}",register);
        Preconditions.checkNotNull(register.getPatientName(),"患者姓名不能为空");
        RegisterPO registerPO = RegisterVOConvert.INSTANCE.RegisterVOTOPO(register);
        registerService.insert(registerPO);
        return Result.ok(true);
    } catch (Exception e) {
        log.error("register.add:{}",e.getMessage(),e);
       return Result.fail("新增数据失败");
    }
}
    @PostMapping("/delete")
    public Result delete(@RequestBody RegisterVO register){
        try {
            log.info("register.delete:{}",register);

            Preconditions.checkNotNull(register.getPatientName(),"患者姓名不能为空");
            Preconditions.checkNotNull(register.getPatientPhone(),"患者手机号不能为空");
            RegisterPO registerPO = RegisterVOConvert.INSTANCE.RegisterVOTOPO(register);
            registerService.update(registerPO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("register.delete:{}",e.getMessage(),e);
            return Result.fail("删除数据失败");
        }
    }
    @PostMapping("/select")
    public Result<RegisterVO> select(@RequestBody RegisterVO register){
        try {
            log.info("register.select:{}",register);

            Preconditions.checkNotNull(register.getPatientName(),"患者姓名不能为空");
            Preconditions.checkNotNull(register.getPatientPhone(),"患者手机号不能为空");
            RegisterPO registerPO = RegisterVOConvert.INSTANCE.RegisterVOTOPO(register);
            RegisterPO registerPO1 = registerService.queryBatch(registerPO);
            RegisterVO registerVO = RegisterVOConvert.INSTANCE.RegisterPOTOVO(registerPO1);

            return Result.ok(registerVO);
        } catch (Exception e) {
            log.error("register.select:{}",e.getMessage(),e);
            return Result.fail("查询数据失败");
        }
    }

}

