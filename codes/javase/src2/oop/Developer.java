package oop;

public class Developer extends Person {

	double salary;
	String department;
	
	public Developer(){
		super(); //default olduqda super() yazila da biler yazilmaya da;
		System.out.println("Developer obj created");
	}
	
	public void printInfo() {
		super.printInfo();
	}
}
