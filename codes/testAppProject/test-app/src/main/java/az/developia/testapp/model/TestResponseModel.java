package az.developia.testapp.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("TestResponseModelFilter")
@AllArgsConstructor
@NoArgsConstructor
public class TestResponseModel {
	private Integer id;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
}
