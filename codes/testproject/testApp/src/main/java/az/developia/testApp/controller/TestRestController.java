package az.developia.testApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.testApp.model.TestModel;
import az.developia.testApp.repository.TestRepository;

@RestController
@RequestMapping(path="/tests")
@CrossOrigin(origins ="*")
public class TestRestController {
	
	@Autowired
	private TestRepository testRepository;

	@PostMapping
	public TestModel addTest(@RequestBody TestModel test) {
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		test.setUser(user);
		return testRepository.save(test);
	}
}
