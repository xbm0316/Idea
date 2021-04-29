package controller;

import javax.servlet.http.HttpSession;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserServiceImpl;


@RequestMapping(value="userController")
@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	//添加用户
	@RequestMapping(value="addUser",method = RequestMethod.POST)
	public String addUser(User user) {
//		System.out.println(user);
		userService.addUser(user);
		return "jsp/index";
	}

	//修改用户
	@RequestMapping(value="updateUser")
	public String updateUser(User user,Model model) {
		int id = userService.findUserId(user.getName());
		user.setId(id);
		userService.updateUser(user);
		model.addAttribute("success", "更新成功！");
		return "jsp/userinfo";
	}

	//退出用户
	@RequestMapping(value="exitUser")
	public String exitUser(HttpSession session) {
		session.removeAttribute("username");
		User user1 = userService.findUser(1);
//		System.out.println(user1);
		return "jsp/index";
	}


}
