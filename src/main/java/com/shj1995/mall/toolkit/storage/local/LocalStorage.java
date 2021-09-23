package com.shj1995.mall.toolkit.storage.local;

import com.shj1995.mall.toolkit.storage.AbstractStorage;
import com.shj1995.mall.toolkit.storage.StorageFile;
import com.shj1995.mall.toolkit.storage.StorageFileImpl;
import com.shj1995.mall.toolkit.storage.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shihaojie
 * @since 2020/9/3 下午5:40
 */
@Slf4j
public class LocalStorage extends AbstractStorage {

    private final StorageProperties properties;

    private String dirPath;
    private String tempPath;

    public LocalStorage(StorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public StorageFile getFile(String id, String fileName) {
        StorageFile storageFile = new StorageFileImpl();
        storageFile.setId(id);
        storageFile.setFileName(fileName);
        String dirPath = this.properties.getLocal().getDirPath();
        File file = new File(dirPath + "/"+storageFile.getStorageFileName());
        if (!file.exists()) {
            log.error("文件未找到,id:{}", id);
        }
        storageFile.setFile(file);
        return storageFile;
    }

    @Override
    public StorageFile importFile(File file) {
        return null;
    }

    @Override
    public StorageFile save(StorageFile file) {
        String dirPath = this.properties.getLocal().getDirPath() + "/";
        try {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                boolean mkdirs = dir.mkdirs();
                if (!mkdirs) {
                    log.error("文件保存失败:文件夹创建失败" );
                }
            }
            String path = dirPath + file.getStorageFileName();
            File destFile = new File(path);
            FileUtils.copyFile(file.getFile(), destFile);
            return file;
        } catch (IOException e) {
            log.error("文件保存失败:", e);
            return null;
        }
    }

    @Override
    public void delete(StorageFile file) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
