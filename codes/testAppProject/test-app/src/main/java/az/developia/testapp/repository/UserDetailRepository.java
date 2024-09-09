package az.developia.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.UserDetailModel;

public interface UserDetailRepository extends JpaRepository<UserDetailModel, Integer> {

}
