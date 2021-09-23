package com.shj1995.mall.toolkit.storage;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author shihaojie
 * @since 2020/9/3 下午4:14
 */
public interface Storage extends InitializingBean {
    StorageFile createFile(String name, String id);

    StorageFile getFile(String id, String fileName);

    StorageFile importFile(java.io.File file);

    StorageFile save(StorageFile file);

    void delete(StorageFile file);
}
