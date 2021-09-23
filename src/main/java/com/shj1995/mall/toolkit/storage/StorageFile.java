package com.shj1995.mall.toolkit.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author shihaojie
 * @since 2020/9/3 下午4:18
 */
public interface StorageFile {
    String getId();
    void setId(String id);

    void setFile(File file);
    File getFile();

    OutputStream openOutputStream() throws FileNotFoundException;
    InputStream openInputStream() throws FileNotFoundException;

    Date getDateExpired();
    void setDateExpired(Date date);

    String getExtensionName();
    String getStorageFileName();
    void  setFileName(String fileName);
    String  getFileName();

}
