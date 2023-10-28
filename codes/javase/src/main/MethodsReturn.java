package main;

public class MethodsReturn {

	public static void main(String[] args) {
		
		Calculator mycalculator=new Calculator();
		
		int result=mycalculator.average(3, 5);
		System.out.println("Ortalama eded:"+result);
		
		int number=mycalculator.average(2, 10);
		System.out.println("Ortalama eded:"+number);
	}

}
