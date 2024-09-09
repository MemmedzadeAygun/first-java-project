package az.developia.testapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.testapp.dto.TopicDTO;
import az.developia.testapp.exception.MyRuntimeException;
import az.developia.testapp.model.TopicModel;
import az.developia.testapp.repository.TopicRepository;

@RestController
@RequestMapping(path="/topics")
@CrossOrigin(origins="*")
public class TopicRestController {
	
	@Autowired
	private TopicRepository topicRepository;

	@PostMapping
	public void createTopic(@Valid @RequestBody TopicDTO topicDTO,BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}else {
			TopicModel topic=new TopicModel();
			topic.setTopicName(topicDTO.getTopicName());
			topic.setTopicLevel(topicDTO.getTopicLevel());
			topicRepository.save(topic);
		}	
	}
	
	
	@GetMapping
	public List<TopicModel> getTopic(){
		return topicRepository.findAll();
	}
	
	
	@PutMapping
	public void updateTopic(@Valid @RequestBody TopicModel topic,BindingResult br) {
		if(br.hasErrors()) {
			throw new MyRuntimeException(br,"Melumatlarin tamligi pozulub");
		}
		
		if(topic.getId()==null || topic.getId()<=0) {
			throw new MyRuntimeException(null,"id mutleqdir");
		}
		
		if(topicRepository.findById(topic.getId()).isPresent()) {
			topicRepository.save(topic);
		}else {
			throw new MyRuntimeException(null,"Bu id tapilmadi");
		}
	}
	
	
	@GetMapping(path="/edit/{id}")
	public TopicModel findById(@PathVariable Integer id) {
		if(id==null || id<=0) {
			throw new MyRuntimeException(null,"Id mutleqdir");
		}
		return topicRepository.findById(id).orElseThrow(()-> new MyRuntimeException(null,"bu id tapilmadi"));
	}
	
	
	@DeleteMapping(path="/delete/{topicId}")
	public void deleteTopic(@PathVariable Integer topicId) {
		topicRepository.deleteById(topicId);
	}
}
