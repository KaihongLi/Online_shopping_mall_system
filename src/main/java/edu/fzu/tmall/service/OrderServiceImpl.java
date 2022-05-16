package edu.fzu.tmall.service;

import java.util.*;

import edu.fzu.tmall.util.DateUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fzu.tmall.mapper.OrderMapper;
import edu.fzu.tmall.pojo.*;
import edu.fzu.tmall.util.Page;

@Service("orderService")
public class OrderServiceImpl  implements OrderService {
	@Autowired
	private  OrderMapper orderMapper;

	/**
	 * 获取订单信息
	 * @param page 分页信息
	 * @return 订单信息分页
	 */
	@Override
	public Page<Order> listByPage(Page<Order> page) {
		RowBounds rowBounds=new RowBounds(page.getStart(),page.getCount());
		Map conMap=new HashMap();
		//TODO 添加代码
		// 获取数据库订单数据
		List<Order> orders=orderMapper.getOrderWithOrderItemAndUser(rowBounds);
		if(Objects.isNull(orders)){
			page.setTotal(0);
			page.setRows(null);
			return null;
		}
		// 填充商品数量，及商品总价
		for(Order r:orders) {
			float total=0;
			int totalNumber=0;
			for(OrderItem o:r.getOrderItems()) {
				total+=o.getNumber()*o.getProduct().getPromotePrice();
				totalNumber+=o.getNumber();
			}
			r.setTotal(total);
			r.setTotalNumber(totalNumber);
		}
		page.setRows(orders);
		page.setTotal(orders.size());
		return page;
	}

	/**
	 * 发货
	 * @param orderId 用户id
	 * @return 订单
	 */
	@Override
	public Order delivery(Integer orderId) {
		//TODO 添加代码
		// 查找相应的订单
		Order order=orderMapper.selectById(orderId);
		// 是否查找成功
		if(Objects.isNull(order)) {
			return null;
		}
		order.setStatus("waitConfirm");
		order.setDeliveryDate(DateUtil.d2t(new Date()));
		// 插入数据库
		int update=orderMapper.updateByPrimaryKey(order);
		if(update<=0){
			return null;
		}
		return order;
	}
}
