package com.shj1995.mall.toolkit.storage;

import com.shj1995.mall.core.utils.FileUtils;
import com.shj1995.mall.toolkit.storage.alioss.AliOssProperties;
import com.shj1995.mall.toolkit.storage.alioss.AliOssStorage;
import com.shj1995.mall.toolkit.storage.local.LocalStorage;
import com.shj1995.mall.toolkit.storage.local.LocalStorageProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author shihaojie
 * @since 2020/9/3 下午5:20
 */
@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "simple.storage")
public class StorageProperties implements InitializingBean {

    private final StrategyEnum DEFAULT_STRATEGY = StrategyEnum.LOCAL;

    private static StorageProperties instance;
    /**
     * 本地文件的根目录
     */
    private String root;
    /**
     * 临时目录
     */
    private String temp;
    /**
     * 缩略图文件夹
     */
    private String thumb;
    /**
     * 文件存储策略
     */
    private StrategyEnum strategy = DEFAULT_STRATEGY;
    /**
     * 阿里oss的配置
     */
    private AliOssProperties aliOss;
    /**
     * 阿里oss的配置
     */
    private LocalStorageProperties local;
    /**
     * 自定义文件存储策略类,需要继承
     */
    private String customStrategyClass;

    @PostConstruct
    public void init() {
        if (StringUtils.isBlank(this.temp)) {
            this.temp = this.root + "/temp";
        }
        if (StringUtils.isBlank(this.thumb)) {
            this.thumb = this.root + "/thumb";
        }
        FileUtils.mkdirIfNoExist(this.temp);
        FileUtils.mkdirIfNoExist(this.thumb);

        if (StringUtils.isBlank(this.local.getDirPath())) {
            this.local.setDirPath(this.root + "/local");
        }
        FileUtils.mkdirIfNoExist(this.local.getDirPath());
    }

    @Bean
    Storage generateStorageBean() throws Exception {
        if (StrategyEnum.LOCAL.equals(strategy)) {
            return new LocalStorage(this);
        } else if (StrategyEnum.ALI_OSS.equals(strategy)) {
            return new AliOssStorage();
        } else  if (StrategyEnum.CUSTOM.equals(strategy)) {
            Object o = Class.forName(customStrategyClass).newInstance();
            if (o instanceof Storage) {
                return (Storage) o;
            } else {
                throw new Exception("文件存储策略配置不正确,自定义类需要继承 com.shj1995.mall.toolkit.storage.Storage ");
            }
        }
        throw new Exception("数据存储策略配置不正确");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StorageProperties.instance = this;
    }

    public static StorageProperties getInstance() {
        return instance;
    }

    enum StrategyEnum {
        LOCAL,
        ALI_OSS,
        GRID_FS,
        CUSTOM
    }

}
