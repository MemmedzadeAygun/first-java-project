package tryCatch;

public class NestedTry_Catch {

	public static void main(String[] args) {
		int[] array= {2,4,6,3};
		
		//Outer try-catch
		try {
			int result=array[4];
			System.out.println("Result:"+result);
			
			
		//Inner try-catch
		try {
			int divisionresult=10/0;
			System.out.println("Divisionresult:"+divisionresult);
		
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
			
	}

}
