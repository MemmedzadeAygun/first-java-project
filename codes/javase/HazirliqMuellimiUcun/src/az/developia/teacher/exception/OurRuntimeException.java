package az.developia.teacher.exception;

public class OurRuntimeException extends RuntimeException {
	private String ourMessage;
	

	public String getOurMessage() {
		return ourMessage;
	}
	
	public OurRuntimeException(String m) {
	this.ourMessage=m;
}
}
