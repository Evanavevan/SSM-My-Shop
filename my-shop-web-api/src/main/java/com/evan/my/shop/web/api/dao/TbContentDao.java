package com.evan.my.shop.web.api.dao;

import com.evan.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    /**
     * 根据类别 ID 查询内容列表
     * @param tbContent {@link TbContent}
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
