package edu.fzu.tmall.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import edu.fzu.tmall.pojo.Product;

public interface ProductMapper {
    Product selectById(Integer id);
    List<Product> selectByConditions(Map conditionMap, RowBounds rowBounds);
    int selectCount(Map conditionMap);
    int deleteById(Integer id);
    int insert(Product product);    
    int update(Product product);
}

