package az.developia.studentcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentcrud.exception.MyRuntimeException;
import az.developia.studentcrud.model.Student;
import az.developia.studentcrud.model.StudentNote;
import az.developia.studentcrud.repository.StudentNoteRepository;
import az.developia.studentcrud.repository.StudentRepository;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private StudentNoteRepository studentNoteRepository;

	@PostMapping
	public Student save(@Valid @RequestBody Student student,BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		return studentrepository.save(student);
	}

	@GetMapping
	public List<Student> findAll() {
		return studentrepository.findAll();
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable Integer id) {
		studentrepository.deleteById(id);
		
		List<StudentNote> studentNotes=studentNoteRepository.findAllByStudentId(id);	
		studentNoteRepository.deleteAll(studentNotes);
		 
	}
	
	@GetMapping(path="/{id}")
	public Student findById(@PathVariable Integer id) {
		return studentrepository.findById(id).get();
	}
	
	
	
}
