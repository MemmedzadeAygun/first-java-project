package az.developia.testapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.testapp.dto.TestDto;
import az.developia.testapp.model.TestAddModel;
import az.developia.testapp.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	
	public List<TestAddModel> getTests(@PathVariable Integer topicId,@RequestParam int pageNo,@RequestParam int recordCount){
		Pageable pageable=PageRequest.of(pageNo, recordCount);
		return testRepository.findByTopicId(topicId, pageable);
	}
}
