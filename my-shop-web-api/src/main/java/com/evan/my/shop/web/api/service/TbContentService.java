package com.evan.my.shop.web.api.service;

import com.evan.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {
    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
