package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.product.entity.Product;
import com.shj1995.mall.product.entity.Spec;
import com.shj1995.mall.product.service.IProductService;
import com.shj1995.mall.product.service.ISpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.shj1995.mall.core.controller.BaseController;

/**
 * <p>
 * 商品规格 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@RestController
@RequestMapping("/product/spec")
@RequiredArgsConstructor
public class SpecController extends BaseController<Spec> {

    private final ISpecService specService;

    @Override
    public IService<Spec> service() {
        return this.specService;
    }
}

