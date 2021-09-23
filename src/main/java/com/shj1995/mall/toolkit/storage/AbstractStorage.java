package com.shj1995.mall.toolkit.storage;

/**
 * @author shihaojie
 * @since 2020/9/4 下午6:01
 */
public abstract class AbstractStorage implements Storage {

    @Override
    public StorageFile createFile(String name, String id) {
        StorageFile storageFile = new StorageFileImpl();
        storageFile.setId(id);
        storageFile.setFileName(name);
        return storageFile;
    }
}
