package az.developia.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testApp.model.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

}
