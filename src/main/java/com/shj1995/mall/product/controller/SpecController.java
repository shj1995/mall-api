package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseCURDController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.product.entity.Spec;
import com.shj1995.mall.product.service.ISpecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品规格 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Api(tags = "商品规格", hidden = true)
@RestController
@RequestMapping("/product/spec")
@RequiredArgsConstructor
public class SpecController extends BaseCURDController<Spec> {

    private final ISpecService specService;

    @Override
    public IService<Spec> service() {
        return this.specService;
    }

    @ApiOperation("根据商品ID获取规格列表")
    @GetMapping("/listByProductId")
    public Result<List<Spec>> listByProductId(@RequestParam Long productId) {
        List<Spec> list = this.specService.list(Wrappers.<Spec>lambdaQuery().eq(Spec::getProductId, productId));
        return Result.ok(list);
    }

}

