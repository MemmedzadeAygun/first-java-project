package p1;

public class Extra {
	
	public int giveArrayElement(int[] array,int index) {
	int result=0;
	
	if(index>=array.length) {
		throw new MyExceptionClass("Olmayan elemente muraciet etdiniz!");
	}
	
	return result=array[index];
	
	/*try {
		 result=array[index];
	
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
	}
		return result ;	*/
	
	}
}
