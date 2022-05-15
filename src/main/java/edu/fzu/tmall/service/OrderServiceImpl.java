package edu.fzu.tmall.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	@Override
	public Page<Order> listByPage(Page<Order> page) {
		RowBounds rowBounds=new RowBounds(page.getStart(),page.getCount());
		Map conMap=new HashMap();
		//TODO 添加代码
		return null;
	}

	@Override
	public Order delivery(Integer orderId) {
		//TODO 添加代码
		return null;
	}
}
