package az.developia.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryproject.model.UserDetailModel;

public interface UserDetailRepository extends JpaRepository<UserDetailModel, Integer> {

}
