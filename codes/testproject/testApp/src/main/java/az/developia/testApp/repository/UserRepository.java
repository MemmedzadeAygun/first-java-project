package az.developia.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testApp.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
