package az.developia.libraryproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.BookModel;
import az.developia.libraryproject.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

}
