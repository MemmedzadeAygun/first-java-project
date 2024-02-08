package az.developia.springjava13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

	@GetMapping
	public String showHome() {
		return "home";
	}

	@GetMapping(path = "/students")
	public String showStudents() {
		return "students";
	}

	@GetMapping(path = "/kitablar")
	public String showBooks() {
		return "books";
	}

	@GetMapping(path = "/computers")
	public String showComputers() {
		System.out.println("salam");
		return "computers";
	}
}
