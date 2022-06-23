package com.shj1995.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.product.dto.ProductQueryReq;
import com.shj1995.mall.product.entity.Product;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
public interface IProductService extends IService<Product> {

    Page<Product> search(ProductQueryReq req);
}
