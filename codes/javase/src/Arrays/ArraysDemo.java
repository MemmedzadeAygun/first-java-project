package Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		
		int massivinelementlerinincemi=0;
		int[] numbers= {5, 12, 7, 9, 10,};
		System.out.println("-------------------");
		for(int i=0;i<numbers.length;i++) {
		massivinelementlerinincemi+=numbers[i];		
		}
		System.out.println("sum="+massivinelementlerinincemi);
		System.out.println("-------------------");
		double edediorta=massivinelementlerinincemi/(numbers.length*1.0);
		System.out.println("average="+edediorta);
		System.out.println("-------------------");
		int minimumelement=numbers[0];
		for(int i=1;i<numbers.length;i++) {
			if(numbers[i]<minimumelement) {
				minimumelement=numbers[i];	
			}
			
		}
		System.out.println("minnumber="+minimumelement);
		System.out.println("-------------------");
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]%2==1) {
				System.out.print(numbers[i]);
				System.out.print(" ,");
			}
		}
		
	}
		
}
