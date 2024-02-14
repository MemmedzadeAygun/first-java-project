package az.developia.springjava13;

import java.util.List;

import az.developia.springjava13.component.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResponse {
	private List<TeacherEntity> teachers;
	private String username;
}
