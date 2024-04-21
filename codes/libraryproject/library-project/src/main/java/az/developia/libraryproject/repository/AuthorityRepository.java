package az.developia.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {

}
