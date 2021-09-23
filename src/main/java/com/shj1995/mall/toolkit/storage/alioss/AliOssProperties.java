package com.shj1995.mall.toolkit.storage.alioss;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shihaojie
 * @since 2020/9/4 下午3:02
 */
@Setter
@Getter
public class AliOssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
