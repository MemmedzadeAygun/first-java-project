package string;

import java.util.Arrays;

public class StringTask {

	public static void main(String[] args) {
		
		String name="Meherrem";
		System.out.println("Name:"+name); //1
		
		String message="Java dilini oyrenmek maraqli ve faydalidir";
		System.out.println("Message:"+message); //2
		
		System.out.println("Length:"+message.length()); //3
		
		char s=message.charAt(7);
		System.out.println("SeventhSymbol:"+s); //4
		
		System.out.println("Index:"+message.indexOf("n")); //5
		
		System.out.println("LowerCase:"+message.toLowerCase()+message); //6
		System.out.println("UpperCase:"+message.toUpperCase()); //7
		
		System.out.println(message.contains("a")); //8
		
		boolean b1=message.endsWith("r");
		System.out.println(b1); 			//9
		
		boolean b2=message.startsWith("H");
		System.out.println(b2);				//10
		
		String name2=" Ayxan ";				//11
		System.out.println("Name2:"+name2.trim()); //12
		
		String name3="Kamil"; 			//13
		String ilkdordsetir=name3.substring(0,Math.min(name3.length(), 4));
		System.out.println(ilkdordsetir);		//14
		
		String name4="Huseyn Mehdizade"; //15
		
		String [] a1Array=name4.split(" ");	//16
		System.out.println(Arrays.toString(a1Array));	//17
		
		
		
	}

}
