package com.shj1995.mall.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.system.entity.Recommend;

/**
 * <p>
 * 推荐栏目 服务类
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
public interface IRecommendService extends IService<Recommend> {
    Recommend detailByCode(String code);

}
