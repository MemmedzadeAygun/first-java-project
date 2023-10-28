package method;

public class MainClass {

	public static void main(String[] args) {
		
		Circle myCircle=new Circle();
		myCircle.radius=5;
		
		Calculator myCalculator=new Calculator();
		myCalculator.calculateCircleLength(myCircle);
		System.out.println(myCircle.length);

	}

}
