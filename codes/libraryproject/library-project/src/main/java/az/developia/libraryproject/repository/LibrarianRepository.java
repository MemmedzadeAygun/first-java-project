package az.developia.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.LibrarianModel;

public interface LibrarianRepository extends JpaRepository<LibrarianModel, Integer>{

}
