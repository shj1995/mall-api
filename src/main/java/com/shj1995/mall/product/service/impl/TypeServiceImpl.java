package com.shj1995.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shj1995.mall.core.controller.req.BaseQueryReq;
import com.shj1995.mall.product.entity.Type;
import com.shj1995.mall.product.mapper.TypeMapper;
import com.shj1995.mall.product.service.ITypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

    @Override
    public Page<Type> search(BaseQueryReq req) {
        Page<Type> page = new Page<>(req.getPage(), req.getSize());
        LambdaQueryWrapper<Type> queryWrapper = Wrappers.<Type>lambdaQuery()
                .like(StringUtils.isNotBlank(req.getKeyword()), Type::getName, req.getKeyword());
        return this.page(page, queryWrapper);
    }
}
