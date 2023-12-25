package az.developia.teacher;

import java.time.LocalDateTime;

import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherGroupRepository;

public class TeacherGroupMain {

	public static void main(String[] args) {
		TeacherGroupEntity teacherGroup = new TeacherGroupEntity(null, "A1", 1, LocalDateTime.of(2022, 12, 15, 20, 20,8),
				15);

		TeacherGroupRepository teacherGroupRepo = new TeacherGroupRepository();
		try {
			teacherGroupRepo.add(teacherGroup);
			 System.out.println(teacherGroupRepo.findById(3));
			teacherGroupRepo.deleteById(1);
			 
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

	}

}
