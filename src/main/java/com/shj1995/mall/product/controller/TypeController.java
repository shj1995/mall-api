package com.shj1995.mall.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseCURDController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.core.controller.req.BaseQueryReq;
import com.shj1995.mall.product.entity.Type;
import com.shj1995.mall.product.service.ITypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Api(tags = "商品类型")
@RestController
@RequestMapping("/product/type")
@RequiredArgsConstructor
public class TypeController extends BaseCURDController<Type> {

    private final ITypeService typeService;

    @Override
    public IService<Type> service() {
        return this.typeService;
    }

    @ApiOperation("分页查询")
    @GetMapping("/search")
    public Result<Page<Type>> search(BaseQueryReq req) {
        return Result.ok(this.typeService.search(req));
    }
}

