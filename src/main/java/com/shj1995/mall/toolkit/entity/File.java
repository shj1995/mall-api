package com.shj1995.mall.toolkit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.shj1995.mall.core.entity.BaseEntity;
import com.shj1995.mall.toolkit.storage.StorageFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文件
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="File对象", description="文件")
public class File extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件类型")
    private String path;

    @ApiModelProperty(value = "MD5")
    private String md5;

    @TableField(exist = false)
    private StorageFile storageFile;
}
