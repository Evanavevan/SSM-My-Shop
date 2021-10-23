package com.evan.my.shop.web.admin.service;

import com.evan.my.shop.commons.persistence.BaseService;
import com.evan.my.shop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds {@link String}
     */
    void deleteByCategoryId(String[] categoryIds);
}
