package main;

public class MainClass {

	public static void main(String[] args) {
		
		Circle myCircle=new Circle();
		myCircle.radius=5;
		
		Calculator_2 myCalculator=new Calculator_2();
		myCalculator.calculateCircleLength(myCircle);
		System.out.println(myCircle.length);

	}

}
