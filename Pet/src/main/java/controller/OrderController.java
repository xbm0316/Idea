package controller;

import java.util.List;

import entity.Order;
import entity.Order_Info;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserServiceImpl;


@RequestMapping(value="orderController")
@Controller
public class OrderController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

//	添加订单

	/**
	 * @param name
	 * @param p_img
	 * @param p_price
	 * @param model
	 * @return
	 */
	@RequestMapping(value="addOrder")
	public String addOrder(@RequestParam(value="username") String name,@RequestParam(value="p_img") String p_img,@RequestParam(value="p_price") int p_price,Model model) {
		Integer id = userService.findUserId(name);
		User user = userService.findUser(id);
		int pid = userService.findProductId(p_img);
		Order order = new Order();
		order.setRe_name(user.getName());
		order.setRe_phone(user.getPhone());
		order.setO_money(p_price);
		order.setRe_address(user.getAddress());
		order.setUser_id(id);
//		System.out.println(user.getId());
		order.setO_pay(0);
		Order_Info orderinfo = new Order_Info();
		//添加订单详情
		orderinfo.setProduct_id(pid);
		orderinfo.setBuynum(1);
		userService.addOrder(order);
		userService.addOrderInfo(orderinfo);
//		System.out.println(order);
		model.addAttribute("img",p_img);
		model.addAttribute("cartsuccess", "加入成功");
		return "jsp/product_info";
	}

	@RequestMapping(value="showCart")
	public String showCart(@RequestParam(value="username") String name,@RequestParam(value="start") int currentPage,Model model) {
		int id = userService.findUserId(name);
		int start = (currentPage-1)*2;
		List<Order> orderlist = userService.findOrder(id,start);
		model.addAttribute("orderlist", orderlist);



//		model.addAttribute("payerror", "购买成功");s
		return "jsp/cart";
	}

	@RequestMapping(value="showPayOrder")
	public String showPayOrder(@RequestParam(value="username") String name,@RequestParam(value="start") int currentPage,Model model) {
		int id = userService.findUserId(name);
		int start = (currentPage-1)*2;
		List<Order> orderlist = userService.findPayOrder(id, start);
		model.addAttribute("orderlist", orderlist);

		return "jsp/pay";
	}


	@RequestMapping(value="showPayCart")
	public String showPayCart(@RequestParam(value="username") String name,@RequestParam(value="start") int currentPage,Model model) {
		int id = userService.findUserId(name);
		int start = (currentPage-1)*2;
		List<Order> orderlist = userService.findOrder(id,start);
		model.addAttribute("orderlist", orderlist);



		model.addAttribute("payerror", "购买成功");
		return "jsp/cart";
	}

	//购买
	@RequestMapping(value="pay")
	public String pay(@RequestParam(value="username") String name,@RequestParam(value="start") int currentPage,Order order,Model model) {
		order.setO_pay(1);
		userService.pay(order);
		model.addAttribute("username", name);
		model.addAttribute("start", currentPage);
//		model.addAttribute("payerror", "购买成功！");

		return "redirect:/orderController/showPayCart";
	}

}
