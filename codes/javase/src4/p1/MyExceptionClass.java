package p1;

public class MyExceptionClass extends RuntimeException {
	private String bizimMesaj; 
	
	public MyExceptionClass(String m) {
		bizimMesaj=m;
	}
	
	public String getbizimMesaj() {
		return bizimMesaj;
	}
}
