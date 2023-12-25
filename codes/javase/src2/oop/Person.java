package oop;

public class Person {
	
	String name;
	String surname;
	
	public Person(String name, String surname) {
		System.out.println("Person obj created, name surname");
		this.name = name;
		this.surname = surname;
	}
	
	public void printInfo() {
		System.out.println("name:"+name);
		System.out.println("surname:"+surname);
	}
	
	public Person() {
		System.out.println("Person obj created");
	}
	
	public void m1() {
		System.out.println("Salam m1");
	}
}
