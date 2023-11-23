package oop3;

public class Main {

	public static void main(String[] args) {
		Cat myCat=new Cat();
		myCat.name="Jerry";
		myCat.age=3;
		myCat.makeNoise();
		
		Dog myDog=new Dog();
		myDog.name="Tom";
		myDog.age=2;
		myDog.makeNoise();
		
		Lion myLion=new Lion();
		myLion.name="MyLion";
		myLion.age=4;
		myLion.makeNoise();
	}

}
