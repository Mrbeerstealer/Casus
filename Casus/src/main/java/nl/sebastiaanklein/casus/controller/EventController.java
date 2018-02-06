//controller event
=======
//Event Controller
>>>>>>> 6b50168a36c1a795b5590012be9a4424c5904992

package nl.sebastiaanklein.casus.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.EventType;
import nl.sebastiaanklein.casus.service.IEventService;
import nl.sebastiaanklein.casus.service.IUserService;

@Controller
public class EventController {
	
	@Autowired
	private IEventService iEventService;
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/event/s/find")
	public String findEvents(Model model) {		
		model.addAttribute("events", this.iEventService.findAll());
		return "events";

	}
	
	@RequestMapping("/event/{id}/find")
	public String findEvent(Model model, @PathVariable Long id) {
		Event event = this.iEventService.findOne(id);
		model.addAttribute("event", event);
		model.addAttribute("userEvents", event.getUserEventList());
		return "event";

	}
	
	@RequestMapping("/event/{id}/add/user")
	public String findUsersForEvent(Model model, @PathVariable Long id) {
		model.addAttribute("eventId", id);
		model.addAttribute("users", this.iUserService.findAll());
		return "userSelect";

	}
	
	@PostMapping("/event/new")
	public String createEvent(HttpServletRequest request){
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		String strDate = request.getParameter("date");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(strDate, formatter);
		
		EventType eventType = EventType.valueOf(request.getParameter("eventType"));
		boolean isPrivate = Boolean.parseBoolean(request.getParameter("isPrivate"));
		double xCoordinate = Double.parseDouble(request.getParameter("xCoordinate"));
		double yCoordinate = Double.parseDouble(request.getParameter("yCoordinate"));
		
		Event event = new Event(name, description, date, eventType, isPrivate, xCoordinate, yCoordinate);
		
		this.iEventService.create(event);
		return "redirect:/event/s/find";
	}

}
