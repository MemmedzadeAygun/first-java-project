package az.developia.testapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tests")
@AllArgsConstructor
@NoArgsConstructor
public class TestAddModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String correct_answer; 
	@ManyToOne
	private TopicModel topic;
	@OneToMany(mappedBy="test")
	private List<AnswerModel> answers;
}
