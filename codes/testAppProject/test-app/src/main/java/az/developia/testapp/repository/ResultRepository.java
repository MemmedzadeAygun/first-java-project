package az.developia.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.ResultModel;
import az.developia.testapp.model.TopicModel;

public interface ResultRepository extends JpaRepository<ResultModel, Integer> {

	ResultModel findByTopic(TopicModel topic);

}
