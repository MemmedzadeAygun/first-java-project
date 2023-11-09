package modifiers;

public class ModifiersDemo {

	public static void main(String[] args) {
		
		Person person=new Person("Jale");
		person.protectedMethod(15);
		person.publicMethod(12);
		person.defaultMethod("050-000-00-00");
		
		person.finalMethod("Xanim", 5);
	}

}
