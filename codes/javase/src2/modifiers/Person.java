package modifiers;

public class Person {
	
	private String name;
	protected int age;
	public int id;
	String phone;
	
	private void privateMethod() {
		
	}
	
	protected void protectedMethod(int age) {
		System.out.println("Age:"+age);
	}
	
	public void publicMethod(int age) {
		System.out.println("Id:"+id);
	}
	
	void defaultMethod(String phone) {
		System.out.println("Phone:"+phone);
	}
	
	//Access modifikatorlara uygun konstruktorlar
	
	public Person(String name) {
		this.name=name;
		System.out.println("Name:"+name);
	}
	
	protected Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	private Person(String name,int age,int id,String phone) {
		this.name=name;
		this.age=age;
		this.id=id;
		this.phone=phone;
	}
	
	Person(String name,int age,int id){
		this.name=name;
		this.age=age;
		this.id=id;
	}
	
	//final method
	public final void finalMethod(final String name,int id) {
		System.out.println("Name:"+name+" "+"Id:"+id);
	}
	
	//static variable
	public static int staticVariable;
}
