package az.developia.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
