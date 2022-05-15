
package edu.fzu.tmall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import edu.fzu.tmall.pojo.Order;
import edu.fzu.tmall.pojo.OrderItem;

public interface OrderItemMapper {
	
   List<OrderItem> selectOrderItems(Integer OrderId);
}