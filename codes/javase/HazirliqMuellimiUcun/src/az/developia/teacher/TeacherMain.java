package az.developia.teacher;

import java.time.LocalDateTime;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMain {

	public static void main(String[] args) {

		// muellim front dan oz melumatlarini daxil edir
		// ve gonderir, bu zaman melumat servere, controllere
		// daxil olur ve bu melumat bazaya yazilmali olduguna gore,
		// servise gonderilir ve servis ise repo ya gonderir,
		// repoda cedvele yazir
		
		TeacherEntity teacher =

				new TeacherEntity(null, "Huseyn", "Huseynov", "099", "Baku", "huseyn1", "1",
						LocalDateTime.of(2010, 6, 15, 15, 14,4));
		LocalDateTime.now();
		
		
		 

		TeacherRepository repository = new TeacherRepository();

		try {
			if (repository.checkUsernameIfExists(teacher.getUsername())) {
				System.out.println("bu username artiq var");
			} else {
				repository.add(teacher);
			}

		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

		// burada bu entity de olan melumatlari teachers cedveline gondermek
		// lazimdir, bunun ucun JDBC kitabxanasini istifade edeceyik

	}

}