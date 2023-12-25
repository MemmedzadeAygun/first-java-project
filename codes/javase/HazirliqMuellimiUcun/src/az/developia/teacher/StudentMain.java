package az.developia.teacher;

import az.developia.teacher.repository.StudentRepository;

public class StudentMain {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			try{StudentRepository repository=new StudentRepository();
			System.out.println(repository.findById(1));
			System.out.println(repository.findAll());
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
