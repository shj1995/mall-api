package com.shj1995.mall.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseCURDController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.system.entity.RecommendItem;
import com.shj1995.mall.system.service.IRecommendItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 推荐项 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
@Api(tags = "推荐项")
@RestController
@RequestMapping("/system/recommend-item")
@AllArgsConstructor
public class RecommendItemController extends BaseCURDController<RecommendItem> {

    private final IRecommendItemService recommendItemService;

    @Override
    public IService<RecommendItem> service() {
        return this.recommendItemService;
    }

    @ApiOperation("根据推荐栏目ID获取规格列表")
    @GetMapping("/listByRecommendId")
    public Result<List<RecommendItem>> listByProductId(@RequestParam Long recommendId) {
        List<RecommendItem> list = this.recommendItemService.list(Wrappers.<RecommendItem>lambdaQuery().eq(RecommendItem::getRecommendId, recommendId));
        return Result.ok(list);
    }

}

