package az.developia.testapp.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import az.developia.testapp.model.TestAddModel;
import az.developia.testapp.model.TopicModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
	private String question;
	
	@NotEmpty(message="Must not be empty")
	@Size(min=1,message="Must be at least 1 characters")
	@Size(max=50,message="Must be a maximum of 50 characters")
	private String option_1;
	
	@NotEmpty(message="Must not be empty")
	@Size(min=1,message="Must be at least 1 characters")
	@Size(max=50,message="Must be a maximum of 50 characters")
	private String option_2;
	
	@NotEmpty(message="Must not be empty")
	@Size(min=1,message="Must be at least 1 characters")
	@Size(max=50,message="Must be a maximum of 50 characters")
	private String option_3;
	
	@NotEmpty(message="Must not be empty")
	@Size(min=1,message="Must be at least 1 characters")
	@Size(max=50,message="Must be a maximum of 50 characters")
	private String option_4;
	
	@NotEmpty(message="Must not be empty")
	@Size(min=1,message="Must be at least 5 characters")
	@Size(max=100,message="Must be a maximum of 50 characters")
	private String correct_answer; 
	@ManyToOne
	private TopicModel topic;
	
	public TestDto(TestAddModel test) {
		this.setQuestion(test.getQuestion());
		this.setOption_1(test.getOption_1());
		this.setOption_2(test.getOption_2());
		this.setOption_3(test.getOption_3());
		this.setOption_4(test.getOption_4());
		this.setTopic(test.getTopic());
	}
}
