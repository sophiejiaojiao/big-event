package com.study.controller;

import com.study.pojo.Article;
import com.study.pojo.Result;
import com.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result<String> list() {
        // 验证token，注释内容通过拦截器实现
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//            return Result.success("所有的文章数据...");
//        } catch (Exception e) {
//            // http响应状态码为401
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("所有的文章数据...");
    }

    @PostMapping
    public Result Add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }
}
