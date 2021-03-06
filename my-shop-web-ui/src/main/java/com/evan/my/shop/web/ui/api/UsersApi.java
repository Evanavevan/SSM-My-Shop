package com.evan.my.shop.web.ui.api;

import com.evan.my.shop.commons.utils.HttpClientUtils;
import com.evan.my.shop.commons.utils.MapperUtils;
import com.evan.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 */
public class UsersApi {

    /**
     * 登录
     * @param tbUser {@link TbUser}
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        return MapperUtils.json2pojoByTree(json, "data", TbUser.class);
    }
}
