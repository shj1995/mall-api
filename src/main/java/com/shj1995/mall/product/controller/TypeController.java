package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.product.entity.Type;
import com.shj1995.mall.product.service.ITypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.shj1995.mall.core.controller.BaseController;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@RestController
@RequestMapping("/product/type")
@RequiredArgsConstructor
public class TypeController extends BaseController<Type> {

    private final ITypeService typeService;

    @Override
    public IService<Type> service() {
        return this.typeService;
    }
}

