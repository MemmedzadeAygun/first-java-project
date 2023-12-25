package main2;

public class Main2 {

	public static void main(String[] args) {
		
		sum(5,7);
		sum(5,7,6);
		sum(5,7,6,9);

	}
	
	static void sum(int...array) {
		
		int sum=0;
		for(int a:array) {
			sum+=a;
		}
		System.out.println(sum);
	}
}
