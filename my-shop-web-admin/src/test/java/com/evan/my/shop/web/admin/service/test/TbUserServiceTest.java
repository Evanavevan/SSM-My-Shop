package com.evan.my.shop.web.admin.service.test;

import com.evan.my.shop.domain.TbUser;
import com.evan.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser: tbUsers) {
            System.out.println(tbUser.toString());
        }
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("123456");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setPhone("11111111111");
        tbUser.setEmail("1365205439@qq.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete() {
        tbUserService.delete(2L);
    }

    @Test
    public void testGetById() {
        System.out.println(tbUserService.getById(1L));
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(1L);
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUserService.update(tbUser);
    }

//    @Test
//    public void testSelectByUsername() {
//        System.out.println(tbUserService.selectByUsername("ad").toString());
//    }

}
