package oop2;

public class Person {
	int id;
	String name;
	String surname;
	int age;
	String phone;
	String address;
	
	public Person(int id,String surname,String name,int age,String phone,String address) {
		this.id=id;
		this.surname=surname;
		this.name=name;
		this.age=age;
		this.phone=phone;
		this.address=address;
	}
	
	public void printInfo() {
		System.out.println("Person id:"+" "+id);
		System.out.println("Person name:"+" "+name);
		System.out.println("Person surname:"+" "+surname);
		System.out.println("Person age:"+" "+age);
		System.out.println("Person phone:"+" "+phone);
		System.out.println("Person address:"+" "+address);
	} 
}
