package nl.sebastiaanklein.casus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import nl.sebastiaanklein.casus.dto.UserEventDto;
import nl.sebastiaanklein.casus.model.DoesAttend;
import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.model.UserEvent;
import nl.sebastiaanklein.casus.service.IEventService;
import nl.sebastiaanklein.casus.service.IUserEventService;
import nl.sebastiaanklein.casus.service.IUserService;

@Controller
public class UserEventController {
	
	@Autowired
	private IEventService iEventService;
	@Autowired
	private IUserEventService iUserEventService;
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/userEvent/new/{id}_{identifier}")
	public String createUserEvent(@PathVariable Long id, @PathVariable Long identifier) {
		Event event = iEventService.findOne(identifier);
		User user = iUserService.findOne(id);
		UserEvent userEvent = new UserEvent();
		userEvent.setUser(user);
		userEvent.setEvent(event);
		
		user.getUserEventList().add(userEvent);
		event.getUserEventList().add(userEvent);
		
		this.iUserEventService.create(userEvent);
		return "redirect:/user/s/find";
	}
	
	@PostMapping("/userEvent/changeAttendance")
	public boolean changeAttendence( @RequestBody UserEventDto userEventDto) {
		
		User user = iUserService.findOne(userEventDto.getEventId());
		Event event = iEventService.findOne(userEventDto.getEventId());
		
		UserEvent userEvent = iUserEventService.findByUserAndEvent(user, event);
		iUserEventService.changeDoesAttend(userEvent, DoesAttend.valueOf(userEventDto.getDoesAttend()));
		
		return true;
	}

}
