package com.shj1995.mall.system.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseCURDController;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.core.exception.BusinessException;
import com.shj1995.mall.core.exception.ExceptionEnum;
import com.shj1995.mall.system.entity.Recommend;
import com.shj1995.mall.system.service.IRecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 推荐栏目 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
@Api(tags = "推荐位")
@RestController
@RequestMapping("/system/recommend")
@AllArgsConstructor
public class RecommendController extends BaseCURDController<Recommend> {

    private final IRecommendService recommendService;

    @Override
    public IService<Recommend> service() {
        return this.recommendService;
    }

    @ApiOperation("根据代码获取")
    @GetMapping("/detailByCode")
    public Result<Recommend> detailByCode(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BusinessException(ExceptionEnum.IS_NOT_NULL, "code");
        }
        return Result.ok(this.recommendService.detailByCode(code));
    }


}

