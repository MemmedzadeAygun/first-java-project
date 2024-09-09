package az.developia.libraryproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryproject.exception.MyRuntimeException;
import az.developia.libraryproject.model.BookModel;
import az.developia.libraryproject.repository.BookRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/books")
@CrossOrigin(origins = "*")
public class BookRestController {
	
	@Autowired
	private BookRepository bookRepository;

	@PostMapping
	public BookModel addBook(@Valid @RequestBody BookModel book,BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		
		return bookRepository.save(book);
		
	}
	
	@GetMapping
	public List<BookModel> findAll(){
		return bookRepository.findAll();
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookRepository.deleteById(id);
	}
	
	@GetMapping(path="/{id}")
	public BookModel editBook(@PathVariable Integer id) {
		return bookRepository.findById(id).get();
	}
	
	
}
