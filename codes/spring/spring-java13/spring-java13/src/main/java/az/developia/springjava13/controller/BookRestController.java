package az.developia.springjava13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Book;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/books")
public class BookRestController {
	
	@Autowired
	private BookRepository repository;

	@PostMapping("/add")
	public void add(@Valid @RequestBody Book s,BindingResult br) {
		if(br.hasErrors())
		{
			throw new OurRuntimeException(br);
			
		}
		System.out.println(s);
		repository.save(s);
		
	}
	
}
