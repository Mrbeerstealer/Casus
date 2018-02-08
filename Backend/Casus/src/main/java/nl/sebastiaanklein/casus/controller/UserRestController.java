package nl.sebastiaanklein.casus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.service.IEventService;
import nl.sebastiaanklein.casus.service.IUserService;

@RestController
public class UserRestController {
	
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IEventService iEventService;
	
	@RequestMapping(value="/getUser", params="userId")
	public User findUserById (@RequestParam Long userId) {
		return iUserService.findOne(userId);		
	}
	
	
	
	/*
	@RequestMapping("/user/s/find")
	public String findUsers(Model model) {	
		model.addAttribute("users", this.iUserService.findAll());
		return "users";

	}
	
	@RequestMapping("/user/{id}/find")
	public String findUser(Model model, @PathVariable Long id) {		
		User user =this.iUserService.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("userEvents", user.getUserEventList());
		return "user";

	}
	
	@RequestMapping("/user/{id}/add/event")
	public String findEventsForUser(Model model, @PathVariable Long id) {
		model.addAttribute("userId", id);
		model.addAttribute("events", this.iEventService.findAllPublic());
		return "eventSelect";

	}
	
	@PostMapping("/user/new")
	public String createUser(HttpServletRequest request){
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		double xCoordinate = Double.parseDouble(request.getParameter("xCoordinate"));
		double yCoordinate = Double.parseDouble(request.getParameter("yCoordinate"));
		
		User user = new User(name, lastName, xCoordinate, yCoordinate);
		
		this.iUserService.create(user);
		return "redirect:/user/s/find";
	}*/

}
