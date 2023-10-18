package main;

public class IncDecOperators {

	public static void main(String[] args) {
		
		int x=1;
		int y=++x;
		System.out.println(y);
		
		int a=6;
		int b=a;
		System.out.println(b++);
		System.out.println(b);
		
		int k=4;
		int l=k+--k%k;
		System.out.println(l);
		
		int d=10;
		int s=--d;
		System.out.println(s);

	}

}
