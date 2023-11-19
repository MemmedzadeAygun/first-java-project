package oop2;

public class Employee extends Person{
	double salary;
	String department;
	String username;
	String password;
	
	public Employee(int id,String name,String surname,int age,String phone,String address,double salary,String department,String username,String password) {
		super(id,name,surname,age,phone,address);
		this.salary=salary;
		this.department=department;
		this.username=username;
		this.password=password;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("Employee salary:"+" "+salary);
		System.out.println("Employee department:"+" "+department);
		System.out.println("Employee username:"+" "+username);
		System.out.println("Employee password:"+" "+password);
	}
	

}
