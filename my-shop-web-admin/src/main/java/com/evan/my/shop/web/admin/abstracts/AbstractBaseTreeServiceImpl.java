package com.evan.my.shop.web.admin.abstracts;

import com.evan.my.shop.commons.persistence.BaseEntity;
import com.evan.my.shop.commons.persistence.BaseTreeDao;
import com.evan.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除
     *
     * @param id {@link Long}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(new String[]{String.valueOf(id)});
    }

    /**
     * 根据 ID 查询信息
     *
     * @param id {@link Long}
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 更新
     *
     * @param entity {@link T}
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid {@link Long}
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }
}
