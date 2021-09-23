package com.shj1995.mall.toolkit.storage;

import lombok.Data;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Date;

/**
 * @author shihaojie
 * @since 2020/9/4 下午4:24
 */
@Data
public class StorageFileImpl implements StorageFile {
    protected String id;
    protected File file;
    protected String fileName;
    protected Date dateExpired;

    public StorageFileImpl() {
    }

    @Override
    public OutputStream openOutputStream() throws FileNotFoundException {
        this.file = new File(StorageProperties.getInstance().getTemp() + "/" + this.getStorageFileName());
        return new FileOutputStream(file);
    }

    @Override
    public InputStream openInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file);
    }

    @Override
    public String getExtensionName() {
        return FilenameUtils.getExtension(this.getFileName());
    }

    @Override
    public String getStorageFileName() {
        String ext = this.getExtensionName();
        if (StringUtils.isNotBlank(ext)) {
            ext = "." + ext;
        }
        return this.id + ext;
    }


}
