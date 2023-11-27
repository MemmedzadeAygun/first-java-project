package tryCatch;

import java.io.IOException;

public class ThrowsKeyWord {

	public static void main(String[] args) {
		
	 try{
		 checkIoException();
		
	 } catch(IOException e) {
		 System.out.println(e.getMessage());
	 }
	}

	private static void checkIoException() throws IOException{
		throw new IOException("Example IoExample");
		
	}

}
