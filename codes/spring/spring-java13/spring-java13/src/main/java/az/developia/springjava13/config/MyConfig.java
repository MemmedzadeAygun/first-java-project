package az.developia.springjava13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.springjava13.component.Computer;
import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Person;

@Configuration
public class MyConfig {

	
	@Bean
	public Person myPerson2() {
		Person s=new Person();
		s.setId(123);
		s.setName("Gunay");
		s.setAge(21);
		s.setSalary(1000);
		return s;
	}
	
	@Bean
	public Computer myComp2() {
		Computer s=new Computer();
		s.setId(123);
		s.setModel("Aspiro");
		s.setColor("Red");
		return s;
	}
	
	@Bean
	public Employee myEmployee2() {
		Employee s=new Employee();
		s.setId(123);
		s.setName("Larry");
		s.setAge(30);
		s.setSalary(4000);
		return s;
	}
}
