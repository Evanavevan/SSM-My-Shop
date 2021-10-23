package com.evan.my.shop.web.admin.abstracts;

import com.evan.my.shop.commons.dto.BaseResult;
import com.evan.my.shop.commons.persistence.BaseTreeEntity;
import com.evan.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @param model {@link Model}
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     *
     * @return
     */
    public abstract String form(T entity);

    /**
     * 保存
     *
     * @param entity {@link T}
     * @param model {@link int}
     * @param redirectAttributes {@link RedirectAttributes}
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param ids {@link String}
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 树形结构
     *
     * @param id {@link Long}
     * @return
     */
    public abstract List<T> treeData(Long id);

    /**
     * 排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId   父节点的 ID
     */
    protected void sortList(List<T> sourceList, List<T> targetList, Long parentId) {
        for (T sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                // 判断有没有子节点，如果有则继续追加
                if (sourceEntity.getIsParent()) {
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList, targetList, sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
