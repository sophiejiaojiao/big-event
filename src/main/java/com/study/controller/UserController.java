package com.study.controller;

import com.study.pojo.Result;
import com.study.pojo.User;
import com.study.service.UserService;
import com.study.utils.JwtUtil;
import com.study.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @RestController：这是一个组合注解，等同于@Controller和@ResponseBody的组合。 1. @Controller是Spring MVC中的一个注解，用于标记这个类是一个控制器类。
 * 2. @ResponseBody则表示该方法的返回结果直接写入 HTTP response body 中，一般在异步获取数据时使用。
 * 在使用了@RestController后，就不需要在每个方法上面添加@ResponseBody了。
 * @Autowired：这个注解用于自动装配Spring容器中的bean。 通过@Autowired，Spring会自动将合适的bean注入到被注解的字段或者方法中。这极大地简化了获取和使用bean的过程。
 * @Validated是Spring框架提供的一个数据验证注解，用于对Controller中的方法参数进行校验。 下方具体校验方式是在对应参数增加了@Pattern正则表达式校验（当然不限定这一种方式）。
 * <p>
 * Controller层：也被称为表现层，主要负责前端请求的接收和响应。
 * Controller层会调用Service层的接口，获取业务逻辑处理的结果，并将结果返回给前端，或者转发到不同的视图进行展示。
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 添加输入内容的正确性校验
        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            // 用户名没被占用，可以注册
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);

        //判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功，生成令牌并返回，用于后续操作的安全性校验
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
}
