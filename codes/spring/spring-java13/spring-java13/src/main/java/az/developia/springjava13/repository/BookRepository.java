package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Integer>{

}
