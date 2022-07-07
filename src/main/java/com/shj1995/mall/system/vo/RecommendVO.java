package com.shj1995.mall.system.vo;

import com.shj1995.mall.system.entity.Recommend;
import com.shj1995.mall.system.entity.RecommendItem;
import lombok.Data;

import java.util.List;

@Data
public class RecommendVO extends Recommend {
    private List<RecommendItem> itemList;
}
