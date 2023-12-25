package oop5;

public class Dog extends Animal{
	
	public Dog(String name) {
		super(name);
		
	}
	@Override
	public void speak() {
		super.speak();
		super.name="Tom";
		System.out.println("Bark!");
	}
}
