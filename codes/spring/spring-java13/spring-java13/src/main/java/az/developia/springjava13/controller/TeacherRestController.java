package az.developia.springjava13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.TeacherResponse;
import az.developia.springjava13.repository.TeacherRepository;

@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
@RestController
public class TeacherRestController {
	
	@Autowired
	private TeacherRepository teacherrepository;

	@GetMapping
	public TeacherResponse getTeachers() {
		TeacherResponse response=new TeacherResponse();
	
		response.setTeachers(teacherrepository.findAll());
		
		return response;
	}
}
