package com.zihenzzz.register.dao;


import com.zihenzzz.register.entity.Register;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Register)表数据库访问层
 *
 * @author makejava
 * @since 2025-02-22 10:08:27
 */
public interface RegisterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Register queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param register 查询条件
     * @return 总行数
     */
    long count(Register register);

    /**
     * 新增数据
     *
     * @param register 实例对象
     * @return 影响行数
     */
    int insert(Register register);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Register> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Register> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Register> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Register> entities);

    /**
     * 修改数据
     *
     * @param register 实例对象
     * @return 影响行数
     */
    int update(Register register);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

