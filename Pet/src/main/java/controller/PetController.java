package controller;

import java.util.List;

import entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserServiceImpl;


@RequestMapping(value="petController")
@Controller
public class PetController {

	@Autowired
	@Qualifier("userService")
	private UserServiceImpl userService;

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	//找宠物1
	@RequestMapping(value="findPet")
	public String findPet(@RequestParam(value="pet") String pet,Model model) {
		List<Pet> petinfo = userService.findPet(pet);
		model.addAttribute("petInfo", petinfo);
		return "jsp/petspecies";
	}

	//找宠物2
	@RequestMapping(value="findCate")
	public String findCate(@RequestParam(value="category") String category,Model model) {
		String url = userService.findPetByCate(category);
		model.addAttribute("img", url);
		return "jsp/petspecies";
	}
}
