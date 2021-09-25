package com.shj1995.mall.product.service.impl;

import com.shj1995.mall.product.entity.Type;
import com.shj1995.mall.product.mapper.TypeMapper;
import com.shj1995.mall.product.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
