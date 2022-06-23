package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.product.dto.ProductCreateReq;
import com.shj1995.mall.product.dto.ProductQueryReq;
import com.shj1995.mall.product.dto.ProductUpdateReq;
import com.shj1995.mall.product.entity.Product;
import com.shj1995.mall.product.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
public class ProductController extends BaseController<Product> {

    private final IProductService productService;

    @Override
    public IService<Product> service() {
        return this.productService;
    }

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result<Product> create(@RequestBody ProductCreateReq req) {
        Product product = new Product();
        BeanUtils.copyProperties(req, product);
        this.service().save(product);
        return Result.ok(product);
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result<Product> update(@RequestBody ProductUpdateReq req) {
        Long id = req.getId();
        if (this.service().getById(id) == null) {
            return Result.fail("数据不存在");
        }
        Product product = new Product();
        BeanUtils.copyProperties(req, product);
        this.service().updateById(product);
        return Result.ok(product);
    }

    @ApiOperation("分页查询")
    @GetMapping("/search")
    public Result<Page<Product>> search(ProductQueryReq req) {
        return Result.ok(this.productService.search(req));
    }

}

