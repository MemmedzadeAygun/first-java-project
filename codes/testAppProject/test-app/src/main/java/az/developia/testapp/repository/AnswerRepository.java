package az.developia.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.AnswerModel;

public interface AnswerRepository extends JpaRepository<AnswerModel, Integer> {

}
