package com.evan.my.shop.web.admin.abstracts;

import com.evan.my.shop.commons.dto.BaseResult;
import com.evan.my.shop.commons.dto.PageInfo;
import com.evan.my.shop.commons.persistence.BaseEntity;
import com.evan.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     */
    public abstract String list();

    /**
     * 跳转到表单页
     *
     */
    public abstract String form();

    /**
     * 保存信息
     *
     * @param entity 实体类
     * @param model 模型
     * @param redirectAttributes 重定向
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     *
     * @param ids
     */
    public abstract BaseResult delete(String ids);

    /**
     * 分页查询
     *
     * @param request
     * @param entity
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<T> page(HttpServletRequest request, T entity) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 dataTables 需要的结果
        PageInfo<T> pageInfo = service.page(start, length, draw, entity);

        return pageInfo;
    }

    /**
     * 跳转详情页
     *
     */
    public abstract String detail();
}
