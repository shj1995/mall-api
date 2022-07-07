package com.shj1995.mall.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shj1995.mall.system.entity.Recommend;
import com.shj1995.mall.system.entity.RecommendItem;
import com.shj1995.mall.system.mapper.RecommendItemMapper;
import com.shj1995.mall.system.mapper.RecommendMapper;
import com.shj1995.mall.system.service.IRecommendService;
import com.shj1995.mall.system.vo.RecommendVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 推荐栏目 服务实现类
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
@Service
@RequiredArgsConstructor
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements IRecommendService {

    private final RecommendItemMapper recommendItemMapper;

    @Override
    public RecommendVO detailByCode(String code) {
        Recommend recommend = this.baseMapper.selectOne(Wrappers.<Recommend>lambdaQuery().eq(Recommend::getCode, code));
        if (recommend == null) {
            return null;
        }
        RecommendVO recommendVo = BeanUtil.copyProperties(recommend, RecommendVO.class);
        recommendVo.setItemList(recommendItemMapper.selectList(Wrappers.<RecommendItem>lambdaQuery().eq(RecommendItem::getRecommendId, recommendVo.getId())));
        return recommendVo;
    }
}
