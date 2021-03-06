
package edu.fzu.tmall.service;

import java.util.List;

import edu.fzu.tmall.pojo.Category;

public interface CategoryService{
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}

