package az.developia.testapp.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import az.developia.testapp.dto.ErrorReportDTO;
import az.developia.testapp.dto.SubmissionDTO;
import az.developia.testapp.dto.TestDto;
import az.developia.testapp.exception.MyRuntimeException;
import az.developia.testapp.model.AnswerModel;
import az.developia.testapp.model.ErrorReport;
import az.developia.testapp.model.ResultModel;
import az.developia.testapp.model.TestAddModel;
import az.developia.testapp.model.TestResponseModel;
import az.developia.testapp.model.TopicModel;
import az.developia.testapp.repository.AnswerRepository;
import az.developia.testapp.repository.ErrorReportRepository;
import az.developia.testapp.repository.ResultRepository;
import az.developia.testapp.repository.TestRepository;
import az.developia.testapp.repository.TopicRepository;
import az.developia.testapp.services.TestService;

@RestController
@RequestMapping(path="/tests")
@CrossOrigin(origins="*")
public class TestRestController {

	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private ErrorReportRepository errorReportRepository;
	
	@Autowired
	private TestService testService;
	
	
	
	@PostMapping(path="/add/test")
	public TestAddModel createTest(@Valid @RequestBody TestDto testDto,BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		TestAddModel testModel=new TestAddModel();
		testModel.setQuestion(testDto.getQuestion());
		testModel.setOption_1(testDto.getOption_1());
		testModel.setOption_2(testDto.getOption_2());
		testModel.setOption_3(testDto.getOption_3());
		testModel.setOption_4(testDto.getOption_4());
		testModel.setCorrect_answer(testDto.getCorrect_answer());
		testModel.setTopic(testDto.getTopic());
		testRepository.save(testModel);
		
		return testModel;
	}
	
	
	@GetMapping(path="/gettest/{topicId}")
	public List<TestDto> getTests(@PathVariable Integer topicId,@RequestParam int pageNo,@RequestParam int recordCount){
		return testService.getTests(topicId, pageNo, recordCount).
				stream().map(TestDto::new).collect(Collectors.toList());
	}
	
	
	@GetMapping(path="/topics")
	public List<TopicModel> getAll(){
		return topicRepository.findAll();
	}
	
	
	
	@GetMapping(path="/test/{pageNo}/{recordCount}")
	public List<TestAddModel> findAll(@PathVariable int pageNo,@PathVariable int recordCount){
		Pageable pageable=PageRequest.of(pageNo, recordCount);
		return testRepository.findAll(pageable).get().toList();
	
	}
//	
//	@GetMapping(path="/topic/{topicId}/{pageNo}/{recordCount}")
//	public List<TestAddModel> getTestByTopic(@PathVariable Integer topicId,@PathVariable int pageNo,@PathVariable int recordCount){
//		Pageable pageable=PageRequest.of(pageNo, recordCount);
//		return testRepository.findByTopicId(topicId,pageable);
//	}
	
	
	@GetMapping(path="/topic/{topicId}")
    public MappingJacksonValue getAllTests(@PathVariable Integer topicId,@RequestParam int pageNo,@RequestParam int recordCount) {
		Pageable pageable=PageRequest.of(pageNo, recordCount);
		List<TestAddModel> tests = testRepository.findByTopicId(topicId,pageable);
        
        List<TestResponseModel> responseModels = new ArrayList<>();
        for (TestAddModel test : tests) {
            TestResponseModel responseModel = new TestResponseModel();
            responseModel.setId(test.getId());
            responseModel.setQuestion(test.getQuestion());
            responseModel.setOption_1(test.getOption_1());
            responseModel.setOption_2(test.getOption_2());
            responseModel.setOption_3(test.getOption_3());
            responseModel.setOption_4(test.getOption_4());
            
            responseModels.add(responseModel);
        }
        
        MappingJacksonValue wrapper = new MappingJacksonValue(responseModels);
        wrapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false).addFilter("TestResponseModelFilter", null));
        
        return wrapper;
    }
	
	
	@PostMapping(path="/submit/{topicId}")
	public void submitTest(@PathVariable Integer topicId, @RequestBody SubmissionDTO submissionDTO) {
		TopicModel topic= topicRepository.findById(topicId)
				.orElseThrow(()-> new RuntimeException("Topic not found"));
		
			int correctCount=0;
			List<AnswerModel> answerModels=new ArrayList<>();
			for(AnswerModel answer:submissionDTO.getAnswers()) {
				TestAddModel test=testRepository.findById(answer.getTest().getId())
						.orElseThrow(()-> new RuntimeException("Test not found"));
				if(answer.getSelectedOption().equals(test.getCorrect_answer())) {
					correctCount++;
				}
				answer.setTest(test);
				
				answer.setTest(test);
				answerModels.add(answer);
		   }
			answerRepository.saveAll(answerModels);
			
			
			ResultModel result=new ResultModel();
			result.setTopic(topic);
			result.setCorrectCount(correctCount);
			result.setTotalQuestions(submissionDTO.getAnswers().size());
			resultRepository.save(result);
	}
	
	
	@GetMapping(path="/result")
	public List<ResultModel> testResult(){
		return resultRepository.findAll();
	}
	
	@GetMapping(path="/result/{topicId}")
	public ResultModel getResult(@PathVariable Integer topicId) {
		TopicModel topic=topicRepository.findById(topicId)
				.orElseThrow(()-> new RuntimeException("Topic not found"));
		
		ResultModel result=resultRepository.findByTopic(topic);
		
		return result;
	}
	
	
	
	@PostMapping(path="/report-error/{testId}")
	public void reportError(@PathVariable Integer testId,@RequestBody ErrorReportDTO errorReportDto) {
		TestAddModel test=testRepository.findById(testId)
				.orElseThrow(()-> new RuntimeException("Test not found"));
		
		ErrorReport errorreport=new ErrorReport();
		errorreport.setTest(test);
		errorreport.setErrorMessage(errorReportDto.getErrorMessage());
		errorReportRepository.save(errorreport);
	}
	

	
	@GetMapping(path="/get-error-reports/{testId}")
	public List<ErrorReportDTO> getErrorReportsForTest(@PathVariable Integer testId) {
	    TestAddModel test = testRepository.findById(testId)
	     .orElseThrow(() -> new RuntimeException("Test not found"));
	    
	    List<ErrorReport> errorReports = errorReportRepository.findByTest(test);

	    List<ErrorReportDTO> errorReportDTOs = errorReports.stream()
	            .map(errorReport -> {
	                ErrorReportDTO dto = new ErrorReportDTO();
	                dto.setErrorMessage(errorReport.getErrorMessage());
	                return dto;
	            })
	            .collect(Collectors.toList());

	    return errorReportDTOs;
	}

	
}
