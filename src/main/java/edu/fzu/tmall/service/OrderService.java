package edu.fzu.tmall.service;

import edu.fzu.tmall.pojo.Order;
import edu.fzu.tmall.pojo.OrderItem;
import edu.fzu.tmall.pojo.User;
import edu.fzu.tmall.util.Page;

import java.util.List;
public interface OrderService {
	Page<Order> listByPage(Page<Order> page);
	Order delivery(Integer orderId);
}
