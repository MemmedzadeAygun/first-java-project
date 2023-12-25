package az.developia.teacher;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMainLogin {

	public static void main(String[] args) {
		
		TeacherRepository repository=new TeacherRepository();
		
		try {
			if(repository.checkUserIfExists("aygun","23")){
				System.out.println("Login oldun");
			}
			else {
				System.out.println("Fail");
			}
		}
		catch(OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
		
		}

}
