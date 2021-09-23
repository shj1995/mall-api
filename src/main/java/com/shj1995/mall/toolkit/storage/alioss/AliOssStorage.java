package com.shj1995.mall.toolkit.storage.alioss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.shj1995.mall.toolkit.storage.AbstractStorage;
import com.shj1995.mall.toolkit.storage.StorageFile;
import com.shj1995.mall.toolkit.storage.StorageFileImpl;
import com.shj1995.mall.toolkit.storage.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author shihaojie
 * @since 2020/9/3 下午6:20
 */
@Slf4j
public class AliOssStorage extends AbstractStorage {
    private OSS ossClient;
    private String bucketName;

    @Override
    public void afterPropertiesSet() throws Exception {
        StorageProperties storageProperties = StorageProperties.getInstance();
        final String accessKeyId = storageProperties.getAliOss().getAccessKeyId();
        final String accessKeySecret = storageProperties.getAliOss().getAccessKeySecret();
        final String endpoint = storageProperties.getAliOss().getEndpoint();
        this.bucketName = storageProperties.getAliOss().getBucketName();
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Override
    public StorageFile getFile(String id ,String fileName) {
        StorageFile storageFile = new StorageFileImpl();
        OSSObject object = this.ossClient.getObject(this.bucketName, id);
        storageFile.setId(id);
        try {
            IOUtils.copy(object.getObjectContent(),storageFile.openOutputStream());
        } catch (IOException e) {
            log.error("获取文件失败");
        }
        return storageFile;
    }

    @Override
    public StorageFile importFile(File file) {
        return null;
    }

    @Override
    public StorageFile save(StorageFile file) {
        try {
            this.ossClient.putObject(this.bucketName, file.getId(), file.openInputStream());
        } catch (FileNotFoundException e) {
            log.error("文件保存失败:", e);
        }
        return file;
    }

    @Override
    public void delete(StorageFile file) {
        this.ossClient.deleteObject(this.bucketName, file.getId());
    }

}
