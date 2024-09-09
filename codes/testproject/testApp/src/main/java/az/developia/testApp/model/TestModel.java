package az.developia.testApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tests")
@Getter
@Setter
public class TestModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String testName;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String answer;
}
