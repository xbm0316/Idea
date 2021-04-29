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


@RequestMapping(value="productController")
@Controller
public class ProductController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	//	找商品
	@RequestMapping(value="findProduct")
	public String findProduct(@RequestParam(value="searchproduct") String category,@RequestParam(value="currentPage",required = false) Integer currentPage,Model model) {
		int start  = (currentPage-1)*8;
		List<Product> products = userService.findProduct(category,start);
		model.addAttribute("productlist", products);
		model.addAttribute("category", category);
		return "jsp/product";

	}

	//	根据图片找到id
	@RequestMapping(value="findProductInfo")
	public String findProductInfo(@RequestParam(value="p_img") String p_img,Model model) {
		int product_id = userService.findProductId(p_img);
//		System.out.println(id);
		Product pinfo = userService.findProductById(product_id);
		model.addAttribute("pinfo", pinfo);

		return "jsp/product_info";
	}

}
