package com.evan.my.shop.commons.persistence;

import com.evan.my.shop.commons.dto.BaseResult;
import com.evan.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询全部
     * @return 用户列表
     */
    public List<T> selectAll();

    /**
     * 保存信息
     * @param entity 用户对象
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除用户信息
     * @param id id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     * @param id id
     * @return 用户
     */
    T getById(Long id);

    /**
     * 更新信息
     * @param entity 用户对象
     */
    void update(T entity);

    /**
     * 批量删除
     * @param ids ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start 起始数
     * @param length 长度
     * @return 用户列表
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     * @return 总数
     */
    int count(T entity);
}
