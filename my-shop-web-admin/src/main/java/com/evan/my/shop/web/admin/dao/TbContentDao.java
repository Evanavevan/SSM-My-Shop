package com.evan.my.shop.web.admin.dao;

import com.evan.my.shop.commons.persistence.BaseDao;
import com.evan.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds {@link String}
     */
    void deleteByCategoryId(String[] categoryIds);
}
