
package edu.fzu.tmall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import edu.fzu.tmall.pojo.Order;

public interface OrderMapper {
	List<Order> selectByConditions(Map conditionMap, RowBounds rowBounds);
	
	Order selectById(Integer id);

	int selectCount(Map conditionMap);

	int updateByPrimaryKey(Order order);
}