package az.developia.libraryproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryproject.model.StudentModel;
import az.developia.libraryproject.repository.StudentRepository;

@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins="*")
public class StudentRestController {
	
	@Autowired
	private StudentRepository studentRepository;

	
	@GetMapping
	public List<StudentModel> findAllStudent(){
		return studentRepository.findAllByLibrarian(getUser());
	}
	
	
	
	private String getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
