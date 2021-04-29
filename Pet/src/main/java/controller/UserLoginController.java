package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.UserServiceImpl;


@SessionAttributes(value = "username")
@RequestMapping(value = "loginController")
@Controller
public class UserLoginController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping(value="checkUser")
	public String checkUser(User user, Model model) {
		Integer id = userService.findUserId(user.getName());
		if(id != null) {
			User userinfo = userService.findUserById(id);
			if(userinfo.getPassword().equals(user.getPassword())) {
				model.addAttribute("username", userinfo.getName());
				return "jsp/index";
			}else {
				model.addAttribute("passerror", "密码错误");
				return "jsp/login";
			}
		}else {
			model.addAttribute("nameerror", "用户名错误");
			return "jsp/login";
		}


	}
}
