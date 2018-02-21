package nl.sebastiaanklein.casus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.sebastiaanklein.casus.dto.EventDto;
import nl.sebastiaanklein.casus.dto.UserDto;
import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.EventType;
import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.service.IEventService;
import nl.sebastiaanklein.casus.service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserRestController {
	
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IEventService iEventService;
	
	@RequestMapping(value="/getUser", params="userId")
	public User findUserById (@RequestParam Long userId) {
		return iUserService.findOne(userId);		
	}
	
	@RequestMapping("/user/s/find")
	public List<User> findUsers() {	
		return this.iUserService.findAll();

	}
	
	@RequestMapping("/user/{id}/find")
	public UserDto findUser(@PathVariable Long id) {
		
		User user = iUserService.findOne(id);
		return UserDto.buildFromUser(user);
	}
	
	@RequestMapping("/event/{id}/find")
	public EventDto findEvent(@PathVariable Long id) {
		System.out.println("iets");
		Event event = iEventService.findOne(id);
		return EventDto.buildFromEvent(event);
	}
	
	@RequestMapping("/event/s/find")
	public List<Event> findEvents() {
		return this.iEventService.findAll();
	}
	
	@RequestMapping("/eventTypes/all")
	public EventType[] findEventTypes() {
		return EventType.values();
	}
	
	@PostMapping("/user/new")
	public boolean createUser(@RequestBody UserDto userDto){
			
		User user = new User(userDto.getName(), userDto.getLastName(), userDto.getxCoordinate(), userDto.getyCoordinate());
		
		this.iUserService.create(user);
		return true;
	}
	
	@PostMapping("/event/new")
	public boolean createEvent(@RequestBody EventDto eventDto){
			
		Event event = new Event(eventDto.getName(), 
								eventDto.getDescription(), 
								eventDto.getDate(),
								eventDto.getEventType(),
								eventDto.isPrivateStatus(), 
								eventDto.getxCoordinate(), 
								eventDto.getyCoordinate());
		
		this.iEventService.create(event);
		return true;
	}
	
/*
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
