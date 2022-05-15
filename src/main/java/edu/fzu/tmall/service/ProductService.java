
package edu.fzu.tmall.service;

import java.util.List;
import java.util.Map;

import edu.fzu.tmall.pojo.Category;
import edu.fzu.tmall.pojo.Product;
import edu.fzu.tmall.util.Page;

public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Map edit(int id);
    Page<Product> list(Integer cid, String keyword, Page<Product> page);
}
