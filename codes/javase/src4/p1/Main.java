package p1;

public class Main {

	public static void main(String[] args) {
		Extra e1=new Extra();
		int[] myArray= {4,2,6,1};
		
		try {
		e1.giveArrayElement(myArray, 10);
		} catch(MyExceptionClass e) {
			System.out.println(e.getbizimMesaj());
		}
		
	}

}
