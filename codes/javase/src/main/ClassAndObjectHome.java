package main;

public class ClassAndObjectHome {

	public static void main(String[] args) {
		
		Person a1=new Person();
		a1.id=256013;
		a1.name="Celil";
		a1.Surname="Memmedquluzade";
		a1.age=40;
		a1.phone="0503745637";
		
		System.out.println("Person's id:" + a1.id);
		System.out.println("Person's name:" + a1.name);
		System.out.println("Person's Surname:" + a1.Surname);
		System.out.println("Person's age:" + a1.age);
		System.out.println("Person's phone:" + a1.phone);
		
		
		Person a2=new Person();
		a2.id=258017;
		a2.name="Yusif";
		a2.Surname="Memmedov";
		a2.age=32;
		a2.phone="0503745638";
		System.out.println(a2);
		
		System.out.println("Person's id:" + a2.id);
		System.out.println("Person's name:" + a2.name);
		System.out.println("Person's Surname:" + a2.Surname);
		System.out.println("Person's age:" + a2.age);
		System.out.println("Person's phone:" + a2.phone);
	}

}
