package main;

public class ClassAndObjectAndConstructorsHome {

	public static void main(String[] args) {
		
		Employee b1=new Employee();
		System.out.println("Employee's id:"+b1.id);
		
		Employee b2=new Employee("Musfiq");
		System.out.println("Employee's name:"+b2.name);
		
		Employee b3=new Employee("Celil","Memmedquluzade");
		System.out.println("Employee's name:"+b3.name);
		System.out.println("Employee's surname:"+b3.surname);
		
		Employee b4=new Employee("Musfiq","+99450-00-00",3000);
		System.out.println("Employee's name:"+b4.name);
		System.out.println("Employee's phone:"+b4.phone);
		System.out.println("Employee's salary:"+b4.salary);
 }

}
