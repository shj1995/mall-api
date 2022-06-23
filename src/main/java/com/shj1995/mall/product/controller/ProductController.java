package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseCURDController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.product.dto.ProductQueryReq;
import com.shj1995.mall.product.entity.Product;
import com.shj1995.mall.product.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Api(tags = "商品")
@RestController
@RequestMapping("/product/product")
@RequiredArgsConstructor
public class ProductController extends BaseCURDController<Product> {

    private final IProductService productService;

    @Override
    public IService<Product> service() {
        return this.productService;
    }

    @ApiOperation("分页查询")
    @GetMapping("/search")
    public Result<Page<Product>> search(ProductQueryReq req) {
        return Result.ok(this.productService.search(req));
    }

}

