package com.study.service;

import com.study.pojo.Category;

import java.util.List;

public interface CategoryService {
    // 新增分类
    void add(Category category);

    // 列表查询
    List<Category> list();

    // 根据id查询分类信息
    Category findById(Integer id);

    // 更新分裂
    void update(Category category);

    // 删除指定id的文章分类
    void delete(Integer id);
}
