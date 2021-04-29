package controller;

import java.util.List;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserServiceImpl;


@RequestMapping(value="search")
@Controller
public class SearchController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;


	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}


	@RequestMapping(value="searchController")
	public String searchController(@RequestParam(value="searchthing") String thing,@RequestParam(value="currentPage",required = false) Integer currentPage,Model model) {
		if(thing.equals("衣服")||thing.equals("猫")||thing.equals("狗")) {
			int start  = (currentPage-1)*8;
			List<Product> products = userService.findProduct(thing,start);
			model.addAttribute("productlist", products);

			model.addAttribute("category",thing);
			return "jsp/product";
		}else if(thing.equals("玩具")) {
			int start  = (currentPage-1)*8;
			List<Product> products = userService.findProduct(thing,start);
			model.addAttribute("productlist", products);

			model.addAttribute("category",thing);
			return "jsp/product";

		}else if(thing.equals("宠物")) {

			return "jsp/petspecies";

		}else {
			model.addAttribute("error","您所搜索的商品这里没有");
			return "jsp/search";
		}


	}
}
