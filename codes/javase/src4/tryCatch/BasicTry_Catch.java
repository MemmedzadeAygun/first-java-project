package tryCatch;

import java.util.Scanner;

public class BasicTry_Catch {
	public static void main(String[] args, int number) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the first order:");
		int a=scanner.nextInt();
		
		System.out.println("Enter the second order:");
		int b=scanner.nextInt();
		
		try{
			int  result=a/b;
			System.out.println("result="+result);
		} catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("The code has ended.");
		}
		
		try {
			checkIfNegative(-4);
			System.out.println("No exception thrown.");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

		private static void checkIfNegative(int number) {
		if(number<0) {
			throw new IllegalArgumentException("Number cannot be negative.");
		}
	}
		private static void checkRange(int number,int upperBound,int lowerBound)throws OutOfRangeValueException{
			if(number>upperBound || number<lowerBound) {
				throw new OutOfRangeValueException("Number is outside the range");
			}
		}
}
