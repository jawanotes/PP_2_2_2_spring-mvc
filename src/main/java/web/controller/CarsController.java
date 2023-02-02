package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
	@Autowired
	private CarService carService;

	@GetMapping(value = "cars")
	public String letThereBeCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
		String attrName = "vehicles"; // because too many "cars" everywhere
		List<String> messages = new ArrayList<>();

		messages.add("Hey there! This is the Cars page!");
		//messages.add("I'm Spring MVC application");
		//messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);

		model.addAttribute(attrName, carService.getCarsByCount(checkCountParameter(count)));
		return "cars";
	}

	private Integer checkCountParameter(Integer count) {
		if((count == null) || (count < 0)) {
			//return Integer.MAX_VALUE;
			count = Integer.MAX_VALUE;
		}
		//return count;
		return Math.min(count, 5);
	}
	
}