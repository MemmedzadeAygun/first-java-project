package az.developia.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
