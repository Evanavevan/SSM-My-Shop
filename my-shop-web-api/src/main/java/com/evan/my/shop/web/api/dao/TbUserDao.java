package com.evan.my.shop.web.api.dao;

import com.evan.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser {@link TbUser}
     * @return
     */
    TbUser login(TbUser tbUser);
}
