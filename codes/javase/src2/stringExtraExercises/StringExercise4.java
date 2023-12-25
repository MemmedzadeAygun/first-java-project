package stringExtraExercises;

public class StringExercise4 {

	public static void main(String[] args) {
		
		String str1="This is first example";
		String str2="This is second example";
		
		int result=str1.compareTo(str2);
		
		if(result<0) {
			System.out.println(str1+"is less than"+str2);
		}
		else if(result==0) {
			System.out.println(str1+"is equal to"+str2);
		}
		else if(result>0) {
			System.out.println(str1+"is greater than"+str2);
		}

	}

}
