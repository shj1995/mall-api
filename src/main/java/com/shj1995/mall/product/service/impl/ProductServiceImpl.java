package com.shj1995.mall.product.service.impl;

import com.shj1995.mall.product.entity.Product;
import com.shj1995.mall.product.mapper.ProductMapper;
import com.shj1995.mall.product.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
