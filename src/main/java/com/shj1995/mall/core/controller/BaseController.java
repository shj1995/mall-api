package com.shj1995.mall.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.req.BaseQueryReq;
import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shj
 * @date 2021/9/21 9:07 下午
 */
public abstract class BaseController<T extends BaseEntity> {

    public abstract IService<T> service();

    @ApiOperation("根据ID获取")
    @GetMapping("/{id}")
    public Result<T> detail(@PathVariable Long id) {
        System.out.println("default get /{id} request");
        Result<T> result;
        if (id == null) {
            result = Result.fail("数据不存在");
        } else {
            T domain = this.service().getById(id);
            if (domain == null) {
                result = Result.fail("数据不存在");
            } else {
                result = Result.ok(domain);
            }
        }
        return result;
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable String id) {
        System.out.println("default delete /{id} request");
        if (this.service().getById(id) == null) {
            return Result.fail("数据不存在");
        }
        this.service().removeById(id);
        return Result.ok(true);
    }

    @ApiOperation("列表查询")
    @GetMapping("/list")
    public Result<List<T>> list() {
        return Result.ok(this.service().list());
    }

}
