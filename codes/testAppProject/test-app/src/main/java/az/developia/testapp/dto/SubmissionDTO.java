package az.developia.testapp.dto;

import java.util.List;

import az.developia.testapp.model.AnswerModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionDTO {
	private Integer topicId;
	private List<AnswerModel> answers;
}
