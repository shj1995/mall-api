package com.shj1995.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.req.BaseQueryReq;
import com.shj1995.mall.product.entity.Type;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
public interface ITypeService extends IService<Type> {

    Page<Type> search(BaseQueryReq req);
}
