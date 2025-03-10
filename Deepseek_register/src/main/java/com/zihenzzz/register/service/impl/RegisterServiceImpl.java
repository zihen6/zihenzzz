package com.zihenzzz.register.service.impl;

import com.zihenzzz.register.dao.RegisterDao;
import com.zihenzzz.register.entity.Register;
import com.zihenzzz.register.service.RegisterService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * (Register)表服务实现类
 *
 * @author makejava
 * @since 2025-02-22 10:08:30
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterDao registerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Register queryById(Integer id) {
        return this.registerDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param register 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Register register) {
        int insert = registerDao.insert(register);
        return insert>0;

    }

    /**
     * 修改数据
     *
     * @param register 实例对象
     * @return 实例对象
     */
    @Override
    public Register update(Register register) {
        this.registerDao.update(register);
        return this.queryById(register.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.registerDao.deleteById(id) > 0;
    }
}
