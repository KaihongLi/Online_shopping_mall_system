
package edu.fzu.tmall.mapper;
import java.util.List;
import java.util.Map;

import edu.fzu.tmall.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);
    
    int insert(Category record);

    List<Category> selectByCondition(Map  map);

    Category selectByPrimaryKey(Integer id);

    int update(Category record);
}
