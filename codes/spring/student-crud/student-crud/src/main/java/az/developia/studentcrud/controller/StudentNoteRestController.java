package az.developia.studentcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentcrud.model.StudentNote;
import az.developia.studentcrud.repository.StudentNoteRepository;

@RestController
@RequestMapping(path = "/student-notes")
@CrossOrigin(origins = "*")
public class StudentNoteRestController {

	@Autowired
	private StudentNoteRepository studentNoteRepository;

	@PostMapping
	public StudentNote save(@Valid @RequestBody StudentNote studentNote) {
		
		return studentNoteRepository.save(studentNote);
	}

	@GetMapping(path="/student/{studentId}")
	public List<StudentNote> findAllByStudentId(@PathVariable Integer studentId) {
		return studentNoteRepository.findAllByStudentId(studentId);
	}

}
