
package edu.fzu.tmall.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fzu.tmall.mapper.CategoryMapper;
import edu.fzu.tmall.mapper.ProductMapper;
import edu.fzu.tmall.pojo.Category;
import edu.fzu.tmall.pojo.Product;
import edu.fzu.tmall.util.Page;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteById(id);
    }

    @Override
    public void update(Product product) {
    	product.setCreateDate(new Date());
        productMapper.update(product);
    }

    @Override
    public Map edit(int id) {
    	Map resultMap=new HashMap<String, Object>();
        Product product = productMapper.selectById(id);
        setCategory(product);
        List<Category> categories=categoryService.list();
        resultMap.put("product", product);
        resultMap.put("categories", categories);
        return resultMap;
    }


    public void setCategory(Product p){
        int cid = p.getCategory().getId();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }

    @Override
    public Page<Product> list(Integer cid ,String keyword, Page<Product> page) {
    	Map<String, Object> conMap=new HashMap<String, Object>();
    	if(cid!=null)
    		conMap.put("cid", cid);
    	if(keyword!=null)
    		conMap.put("keyword", keyword);
    	conMap.put("OrderByClause", "id desc");
        RowBounds rowBounds=new RowBounds(page.getStart(), page.getCount());
        List result = productMapper.selectByConditions(conMap,rowBounds);
        Integer total=productMapper.selectCount(conMap);
        page.setRows(result);
        page.setTotal(total);
        return page;
    }
}
