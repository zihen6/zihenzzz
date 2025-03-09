package com.zihenzzz.register.service;


import com.zihenzzz.register.entity.po.RegisterPO;

/**
 * (Register)表服务接口
 *
 * @author makejava
 * @since 2025-02-22 10:08:29
 */
public interface RegisterService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RegisterPO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param register 实例对象
     * @return 实例对象
     */
    Boolean insert(RegisterPO register);

    /**
     * 修改数据
     *
     * @param register 实例对象
     * @return 实例对象
     */
    Boolean update(RegisterPO register);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    RegisterPO queryBatch(RegisterPO registerPO);
}
