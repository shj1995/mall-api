package com.shj1995.mall.toolkit.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseController;
import com.shj1995.mall.toolkit.entity.Zone;
import com.shj1995.mall.toolkit.service.IZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2022-06-20
 */
@RestController
@RequestMapping("/toolkit/zone")
@RequiredArgsConstructor
public class ZoneController extends BaseController<Zone> {

    private final IZoneService zoneService;

    @Override
    public IService service() {
        return zoneService;
    }
}

