package com.study.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;
// @NotNull表示必须传，@NotEmpty表示必须传，并且有值

@Data
public class Category {
    // id指定了分组，所以不属于Default分组，那么下方的Add继承Default就不会有id属性
    @NotNull(groups = Update.class)
    private Integer id;//主键ID
    // @NotEmpty(groups = {Update.class, Add.class})
    @NotEmpty
    private String categoryName;//分类名称
    @NotEmpty(groups = {Update.class, Add.class})
    private String categoryAlias;//分类别名
    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updateTime;//更新时间

    // 定义两个分组，将对象通过groups方式划分分组，在Controller中进行分组检验
    // 如果没有指定分组，则属于默认Default分组
    // 若某个校验项属于多个分组，可以通过分组之间的继承来实现，如A extends B，那么A拥有B的所有校验项
    public interface Add extends Default {
    }

    public interface Update extends Default {
    }
}
