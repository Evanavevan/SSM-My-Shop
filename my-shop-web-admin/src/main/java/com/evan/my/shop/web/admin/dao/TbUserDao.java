package com.evan.my.shop.web.admin.dao;

import com.evan.my.shop.commons.persistence.BaseDao;
import com.evan.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email {@link String}
     * @return
     */
    TbUser getByEmail(String email);
}
