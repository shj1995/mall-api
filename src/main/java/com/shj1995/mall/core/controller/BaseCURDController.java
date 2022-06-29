package com.shj1995.mall.core.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shj
 * @date 2021/9/21 9:07 下午
 */
public abstract class BaseCURDController<T extends BaseEntity> {

    public abstract IService<T> service();


    @ApiOperation("创建")
    @ApiOperationSupport(ignoreParameters = {"req.id", "req.updateTime", "req.createTime", "req.updateUserId", "req.createUserId", "deleted"})
    @PostMapping("/create")
    public Result<T> create(@RequestBody T req) {
        this.service().save(req);
        return Result.ok(req);
    }


    @ApiOperation("更新")
    @PutMapping("/update")
    @ApiOperationSupport(ignoreParameters = {"req.updateTime", "req.createTime", "req.updateUserId", "req.createUserId", "deleted"})
    public Result<T> update(@RequestBody T req) {
        Long id = req.getId();
        if (this.service().getById(id) == null) {
            return Result.fail("数据不存在");
        }
        this.service().updateById(req);
        return Result.ok(req);
    }

    @ApiOperation("根据ID获取")
    @GetMapping("/detailById/{id}")
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
    @DeleteMapping("/deleteById/{id}")
    public Result<Boolean> deleteById(@PathVariable String id) {
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
