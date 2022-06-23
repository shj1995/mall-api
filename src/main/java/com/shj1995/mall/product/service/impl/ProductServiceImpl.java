package com.shj1995.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shj1995.mall.product.dto.ProductQueryReq;
import com.shj1995.mall.product.entity.Product;
import com.shj1995.mall.product.mapper.ProductMapper;
import com.shj1995.mall.product.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public Page<Product> search(ProductQueryReq req) {
        Page<Product> page = new Page<>(req.getPage(), req.getSize());
        LambdaQueryWrapper<Product> queryWrapper = Wrappers.<Product>lambdaQuery()
                .like(StringUtils.isNotBlank(req.getName()), Product::getName, req.getName());
        return this.page(page, queryWrapper);
    }
}
