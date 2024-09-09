package az.developia.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.TopicModel;

public interface TopicRepository extends JpaRepository<TopicModel, Integer> {

}
