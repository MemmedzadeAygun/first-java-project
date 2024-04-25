package az.developia.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testApp.model.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Integer> {

}
