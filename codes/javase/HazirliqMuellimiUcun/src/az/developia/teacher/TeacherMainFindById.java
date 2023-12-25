package az.developia.teacher;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMainFindById {

	public static void main(String[] args) {

		try {
			TeacherRepository repository = new TeacherRepository();
			System.out.println(repository.findById(6));
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

	}

}