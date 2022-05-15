package edu.fzu.tmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fzu.tmall.pojo.Order;
import edu.fzu.tmall.service.OrderService;
import edu.fzu.tmall.util.Page;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderSevice;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(required = false) Integer start) {
		Page<Order> page;
		if (start == null) {
			page = new Page<Order>(0, 10);
		} else {
			page = new Page<Order>(start, 10);
		}
		//TODO 补充代码
		return "admin/order/listOrder";
	}

	@RequestMapping("/delivery")
	public String delivery(@RequestParam Integer orderId) {
		orderSevice.delivery(orderId);
		return "forward:list";
	}
}
