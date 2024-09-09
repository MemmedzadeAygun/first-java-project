package az.developia.testapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TopicDTO {
	@NotNull(message="Must not be empty")
	@Size(min=3,message="Must be at least 3 characters")
	@Size(max=20,message="Must be maximum 20 characters")
	private String topicName;
	
	@NotNull(message="Must not be empty")
	@Size(min=3,message="Must be at least 3 characters")
	@Size(max=10,message="Must be maximum 10 characters")
	private String topicLevel;
}
