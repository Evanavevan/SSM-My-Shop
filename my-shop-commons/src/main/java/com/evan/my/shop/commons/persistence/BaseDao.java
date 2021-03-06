package com.evan.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询全部数据
     */
    List<T> selectAll();

    /**
     * 新增
     *
     * @param entity 新用户
     */
    void insert(T entity);

    /**
     * 删除
     *
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 根据 ID 查询信息
     *
     * @param id id
     * @return 用户对象
     */
    T getById(Long id);

    /**
     * 更新
     *
     * @param entity 用户对象
     */
    void update(T entity);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param params，需要两个参数，start/记录开始的位置 length/每页记录数
     * @return 用户对象
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询总笔数
     *
     * @return 总数
     */
    int count(T entity);
}
