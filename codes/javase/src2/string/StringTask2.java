package string;

import java.util.Random;

public class StringTask2 {
	
	public static boolean strMethod(String firstline,String secondline) {
		return firstline.endsWith(secondline);	//4
	}
	 

	public static void main(String[] args) {
		
		boolean result=strMethod("This is the first string","This is the second string");
		System.out.println("Result:"+result);			//4
		
		char[] charArray=new char[] {'s','a','l','a','m'};
		String s=String.valueOf(charArray);
		System.out.println(s);				//1
		
		String a="Qebele";
		if(a.length()==3) {
			System.out.println("The value consists of three carachters");
		}
		else {
			System.out.println("The value does not contain three carachters");	//2
		}
		
		String b=" ";
		if(b.isBlank()) {
			System.out.println("Setir bosdur");
		}
		else {
			System.out.println("Setir doludur");	//3
		}
		
		double d=73.6754;
		String result2=String.format("%.2f",d);
		System.out.println(result2);					//6
		
		//5?
		
	}

}
