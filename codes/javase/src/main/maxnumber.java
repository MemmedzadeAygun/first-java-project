package main;

public class maxnumber {

	public static void main(String[] args) {
		
		int number=31284;
		int max=0;	
		while(number>0) {
			int r=number%10;
			if(r>max) {
				max=r;
			}
			number=number/10;
		}
				
		System.out.println(max);
	}	
}
