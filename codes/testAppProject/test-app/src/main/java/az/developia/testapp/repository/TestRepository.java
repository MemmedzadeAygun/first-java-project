package az.developia.testapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.TestAddModel;

public interface TestRepository extends JpaRepository<TestAddModel, Integer> {
	
	List<TestAddModel> findByTopicId(Integer topicId,Pageable pageable);

}
