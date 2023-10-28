package pass_by_reference;

public class Person {
	
	String name,surname,phone;
	int experienceYear;
	double salary;
	
	public void printInfo() {
		System.out.println("name:"+name);
		System.out.println("surname:"+surname);
		System.out.println("phone:"+phone);
		System.out.println("ExperienceYear:"+experienceYear);
		System.out.println("salary:"+salary);
	}
	
	Person(String name,String surname,String phone,int experienceYear){
		this.name=name;
		this.surname=surname;
		this.phone=phone;
		this.experienceYear=experienceYear;
	}
}
