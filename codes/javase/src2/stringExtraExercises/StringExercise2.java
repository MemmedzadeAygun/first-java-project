package stringExtraExercises;

public class StringExercise2 {

	public static void main(String[] args) {
		
		String str="w3resource.com";
		
		int point1=str.codePointAt(2);
		int point2=str.codePointAt(10);
		
		System.out.println("Character(unicode point)="+point1);
		System.out.println("Character(unicode point)="+point2);
		
		int point3=str.codePointBefore(1);
		int point4=str.codePointBefore(9);
		
		System.out.println("Character(unicode point)="+point3);
		System.out.println("Character(unicode point)="+point4);
		
		
	}

}
