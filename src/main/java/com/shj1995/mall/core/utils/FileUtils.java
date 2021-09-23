package com.shj1995.mall.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public final class FileUtils {
    private FileUtils() {
    }

    /**
     * 判断文件夹是否存在,不存在就创建
     *
     * @param path 目录地址
     */
    public static void mkdirIfNoExist(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            boolean mkdirs = dir.mkdirs();
            if (!mkdirs) {
                log.error("文件夹初始化失败");
            }
        }
    }
}
