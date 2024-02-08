package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.BookEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;

@RestController
@RequestMapping(path = "/books")
public class BookRestController {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public List<BookEntity> getBooks() {
		return repository.findAll();
	}

	@PostMapping("/add")
	public void add(@Valid @RequestBody BookEntity s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumatlarin tamligi pozulub");
		}
		// System.out.println(s);
		s.setId(null);
		repository.save(s);
	}

	@PutMapping(path = "/update")
	public void update(@Valid @RequestBody BookEntity s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumatlarin tamligi pozulubdur");
		}

		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(br, "id mutleqdir");
		}

		if (repository.findById(s.getId()).isPresent()) { // olmayan id'ye muraciet etdikde
			repository.save(s);
		} else {
			throw new OurRuntimeException(br, "bu id tapilmadi");
		}
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}
	}

	@GetMapping(path = "/{id}")
	public BookEntity findById(@PathVariable Integer id) {

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		Optional<BookEntity> o = repository.findById(id);
		if (o.isPresent()) { // olmayan id'ye muraciet etdikde
			return o.get();
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

	}
}

//Qeyd- @RequestBody annotasiyasi JSON melumatlarini avtomatik Java sinifine cevirir. 
