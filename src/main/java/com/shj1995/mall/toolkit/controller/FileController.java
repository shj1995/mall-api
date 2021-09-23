package com.shj1995.mall.toolkit.controller;


import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.google.common.collect.Lists;
import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.core.utils.UUIDUtils;
import com.shj1995.mall.toolkit.entity.File;
import com.shj1995.mall.toolkit.service.IFileService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.shj1995.mall.core.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.ZoneOffset;
import java.util.List;

/**
 * <p>
 * 文件 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-22
 */
@Slf4j
@Api(tags = "文件相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/toolkit/file")
public class FileController {

    private static final int MAX_AGE = 7 * 60 * 60 * 24; //缓存七天
    private final IFileService fileService;
    private final HttpServletResponse response;

    @PostMapping("/upload")
    public Result<Long> upload(@RequestParam("file") MultipartFile partFile) {
        if (partFile == null) {
            return Result.fail("文件不能为空");
        }
        File file = this.fileService.upload(partFile);
        return Result.ok(file.getId());
    }

    @PostMapping("/multiUpload")
    public Result<List<Long>> multiUpload(@RequestParam("file") MultipartFile[] multipartFiles) {
        if (multipartFiles.length == 0) {
            return Result.fail("文件不能为空");
        }
        List<Long> fileIds = Lists.newArrayList();
        for (MultipartFile partFile : multipartFiles) {
            File file = this.fileService.upload(partFile);
            fileIds.add(file.getId());
        }
        return Result.ok(fileIds);
    }


    @GetMapping("/{id}/view")
    public void view(@PathVariable("id") Long id) {
        File file = this.fileService.getFile(id);
        if (file == null) {
            sendError(HttpServletResponse.SC_NOT_FOUND, "The File[" + id + "] Not Found");
            return;
        }
        long updateTime = file.getUpdateTime().toEpochSecond(ZoneOffset.of("+8"));
        try (InputStream inputStream = file.getStorageFile().openInputStream()) {
            dealFile(inputStream, file.getSize(), updateTime, file.getType());
        } catch (IOException e) {
            log.error("server error", e);
            sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    private void dealFile(InputStream input, long size, long lastModifyDate, String mimeType) {
        if ((StringUtils.contains(mimeType, "javascript") || StringUtils.contains(mimeType, "text"))) {
            this.response.setContentType("text/plain");
        } else {
            this.response.setContentType(mimeType);
        }
        sendInputStream(input, size, lastModifyDate);
    }

    private void sendInputStream(InputStream input, long size, long lastModifyDate) {
        try (OutputStream out = this.response.getOutputStream()) {
            this.response.setHeader("Pargma", "max-age=" + MAX_AGE);
            this.response.setHeader("Cache-Control", "max-age=" + MAX_AGE);
            if (lastModifyDate > 0) {
                this.response.setDateHeader("Last-Modified", lastModifyDate);
            }
            this.response.setContentLength((int) size);
            IOUtils.copy(input, out);
        } catch (IOException e) {
            sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void sendError(int code, String message) {
        if (HttpServletResponse.SC_INTERNAL_SERVER_ERROR == code) {
            this.response.setHeader("Pargma", null);
            this.response.setHeader("Cache-Control", null);
        }
        try {
            this.response.sendError(code, message);
        } catch (IOException e) {
            log.error("response send error", e);
        }
    }
}

