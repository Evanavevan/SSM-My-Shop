package com.evan.my.shop.web.api.service;

import com.evan.my.shop.domain.TbUser;

/**
 * 会员管理
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
