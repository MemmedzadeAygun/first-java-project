package main;

public class Employee {
	
	int id;
	String name;
	String surname;
	String phone;
	String adress;
	int salary;
	
	public Employee(){
		this.id=0;
	}
	
	public Employee(String name) {
		this.name=name;
	}
	
	public Employee(String name,String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	public Employee(String name,String phone,int salary) {
		this.name=name;
		this.phone=phone;
		this.salary=salary;
	}
	

}
