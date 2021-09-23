package com.shj1995.mall.toolkit.service;

import com.shj1995.mall.toolkit.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件 服务类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-22
 */
public interface IFileService extends IService<File> {

    File upload(MultipartFile partFile);

    File getFile(Long id);

    String getFilePath(Long id);

    boolean isExists(Long id);
}
