package main2;

public class ToString {

	public static void main(String[] args) {
		
	/*char[] Simvolmassivi=new char[] {'s','a','l','a','m'};
		String Simvoldeyiseni=String.copyValueOf(Simvolmassivi,2,3);
		System.out.println(Simvoldeyiseni);*/
		
		/*String s="Java programming language is good programming language";
		char c=s.charAt(5);
		System.out.println(c);*/
		
		/*String q1=new String("Java");
		String q2="Java";
		System.out.println(q1.equals(q2));*/
		
		/*String s="Java programming language is good programming language";
		String e1="language";
		System.out.println(s.indexOf(e1));
		System.out.println(s.indexOf("a"));
		System.out.println(s.lastIndexOf("lang"));*/
		
		/*String email="memmedzadeaygun2004@gmail.com";
		System.out.println(email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]{2,4})$"));*/
		
		String s1="Developia";
		String s2="Develeoper";
		
		System.out.println(s1.regionMatches(0,s2,0,5));
	
	}

}
