package com.shj1995.mall.toolkit.controller;

import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.core.enums.BaseEnum;
import com.shj1995.mall.core.enums.EnumEntity;
import com.shj1995.mall.product.enums.ProductStatusEnum;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Api(tags = "枚举相关接口")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/enums")
public class EnumController {

    public static void main(String[] args) {
        System.out.println(ProductStatusEnum.REMOVED.name());
    }

    @GetMapping("/list")
    public Result<List<EnumEntity>> list(@RequestParam("className")String className) {
        try {
            Class<? extends BaseEnum> aClass = (Class<? extends BaseEnum>) Class.forName(className);
            List<EnumEntity> baseEnums = Arrays.stream(aClass.getEnumConstants()).map(EnumEntity::new).collect(Collectors.toList());
            return Result.ok(baseEnums);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
