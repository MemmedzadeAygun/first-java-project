package Arrays;

import java.util.ArrayList;

public class ArraysDemoHome {

	public static void main(String[] args) {
	
		int[] numbers= {10, 8, 12,5};
		int sum=0;
		for(int i=0;i<numbers.length;i++) {
			sum=sum+numbers[i];
		}
		
		System.out.println("sum="+sum);
		double average=sum/(numbers.length*1.0);
		System.out.println("average="+average);
		
		int maxelement=numbers[0];
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]>maxelement) {
				maxelement=numbers[i];
				
			}
		}
		System.out.println("maxelement="+maxelement);
		
		int minelement=numbers[0];
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]<maxelement) {
				minelement=numbers[i];
			}
		}
		System.out.println("minelement="+minelement);
		
		for(int i=0; i<numbers.length;i++) {
			if(numbers[i]%2==1) {
				System.out.println("odd numbers="+numbers[i]);
			}	
		}
		
		for(int i=0; i<numbers.length;i++) {
			if(numbers[i]%2==0) {
				System.out.println("even numbers="+numbers[i]);
				
			}
		}
		
		for(int eded:numbers) {
			System.out.print(eded);
			System.out.print(" ,");
		}
				
	}

	
		
}
