package com.evan.my.shop.web.admin.service;

import com.evan.my.shop.commons.persistence.BaseService;
import com.evan.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email {@link String}
     * @param password {@link String}
     * @return
     */
    TbUser login(String email, String password);
}
