package tryCatch;

public class InvalidUserInputExc {

	public static void main(String[] args) {
	 try{
		userInput("Invalid Input");
	 } catch(InvalidUserInputException e) {
		 System.out.println(e.getMessage());
	 }
	 }

	private static void userInput(String checkuserInput) throws InvalidUserInputException{
		if(checkuserInput.equals("Invalid Input")) {
			throw new InvalidUserInputException(checkuserInput);
		} else {
			System.out.println(checkuserInput);
		}
		
	}

}
