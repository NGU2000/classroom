package com.atguigu.ggkt.vod.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author atguigu
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class  Subject implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 类别名称
     */
    @ApiModelProperty(value="title")
    @TableField("title")
    private String title;

    /**
     * 父ID
     */
    @ApiModelProperty(value="parentId")
    @TableField("parent_id")
    private Long parentId;

    /**
     * 排序字段
     */
    @ApiModelProperty(value="sort")
    @TableField("sort")
    private Integer sort;

    /**
     * 创建时间
     */

    @ApiModelProperty(value="createTime")
    @JsonFormat(pattern="yyyy-HH-dd hh:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value="updateTime")
    @JsonFormat(pattern="yyyy-HH-dd hh:mm:ss")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value="isDeleted")
    @JsonIgnore
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="ifhaschildnode")
    @TableField(exist = false)
    private boolean hasChildren;

}
