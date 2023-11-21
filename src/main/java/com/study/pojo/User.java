package com.study.pojo;



import lombok.Data;

import java.time.LocalDateTime;

/**
 * lombok工具：在编译阶段为实体类自动生成setter、getter、toString等方法
 * lombok使用方式：
 * 1. 需要在pom文件引入依赖。
 * 2. 在实体类上添加注解。
 */
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
