package az.developia.springjava13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Home;
import az.developia.springjava13.component.Person;

@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext a =SpringApplication.run(SpringJava13Application.class, args);
		
	//	Person personBean= a.getBean("myPerson1",Person.class);
	//	System.out.println(personBean.getName());
	//	System.out.println(personBean.getComputer().getModel());
		
	//	Employee employeeBean=a.getBean("myEmployee2",Employee.class);
	//	System.out.println(employeeBean.getName());
	//	System.out.println(employeeBean.getComputer().getColor());
		
	//	Home homeBean = a.getBean(Home.class);
		
	//	Home homeBean2 = a.getBean(Home.class);
		//singleton
		//prototype
		
		//String[] beanNames = a.getBeanDefinitionNames();
		//for (String beanName: beanNames) {
		//	System.out.println(beanName);
			
//		}
	}
}
