package az.developia.libraryproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Integer>{

	
}
