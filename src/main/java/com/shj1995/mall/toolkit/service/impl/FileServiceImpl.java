package com.shj1995.mall.toolkit.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shj1995.mall.core.utils.UUIDUtils;
import com.shj1995.mall.toolkit.entity.File;
import com.shj1995.mall.toolkit.mapper.FileMapper;
import com.shj1995.mall.toolkit.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shj1995.mall.toolkit.storage.Storage;
import com.shj1995.mall.toolkit.storage.StorageFile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-22
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    private final Storage storage;

    @Override
    public File upload(MultipartFile partFile) {
        String fileName = partFile.getOriginalFilename();
        String fileType = partFile.getContentType();

        File file = new File();
        file.setName(fileName);
        file.setType(fileType);
        file.setSize(partFile.getSize());
        this.baseMapper.insert(file);

        StorageFile storageFile = storage.createFile(fileName, file.getId().toString());
        try (InputStream in = partFile.getInputStream(); OutputStream out = storageFile.openOutputStream()) {
            IOUtils.copy(in, out);
            this.storage.save(storageFile);
        } catch (IOException e) {
            log.error("上传文件失败:", e);
        }
        return file;
    }

    @Override
    public File getFile(Long id) {
        File file = this.baseMapper.selectById(id);
        if (file != null) {
            String fileName = file.getName();
            file.setStorageFile(this.storage.getFile(id.toString(), fileName));
        }
        return file;
    }

    @Override
    public String getFilePath(Long id) {
        File file = this.getFile(id);
        return file.getStorageFile().getStorageFileName();
    }

    @Override
    public boolean isExists(Long id) {
        if (id == null) {
            return false;
        }
        return this.baseMapper.selectCount(Wrappers.<File>lambdaQuery().eq(File::getId, id)) > 0;
    }
}
