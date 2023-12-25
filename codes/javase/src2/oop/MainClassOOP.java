package oop;

public class MainClassOOP {

	public static void main(String[] args) {
		
		//Person p1=new Person("Adil","Memmedov");
		//p1.printInfo();
		
		Developer d1=new Developer();
		
		//Alt sinifin obyektini ust sinifin referensine menimsetmek olar.
		
		Person p1=new Developer();
		
		simpleMethod(p1);
		
	}
	
	public static void simpleMethod(Person p) {
		p.m1();
	}
	

}
