package com.study.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * lombok工具：在编译阶段为实体类自动生成setter、getter、toString等方法
 * lombok使用方式：
 * 1. 需要在pom文件引入依赖。
 * 2. 在实体类上添加注解。
 *
 * @JsonIgnore：springmvc将当前对象转换成Json数据时，忽略该对象，即转成的Json字符串中无该对象
 * @NotNull等为字段有效性验证，标识后，在具体的Controller的接口的实体参数前用@Validated注解标识进行有效性验证
 */
@Data
public class User {
    @NotNull
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore
    private String password;//密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//昵称
    @NotEmpty
    @Email
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
