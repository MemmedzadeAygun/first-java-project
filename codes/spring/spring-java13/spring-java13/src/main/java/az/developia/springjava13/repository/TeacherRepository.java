package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer>{
	//select * from teachers where username='developer'
	TeacherEntity findByUsername(String username);

}
