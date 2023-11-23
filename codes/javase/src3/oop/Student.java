package oop;

public class Student {
	String name;
	int age;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		if(age>=0) {
			this.age=age;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
