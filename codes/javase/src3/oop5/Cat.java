package oop5;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void speak() {
		super.speak();
		System.out.println("Meow!");
	}
}
