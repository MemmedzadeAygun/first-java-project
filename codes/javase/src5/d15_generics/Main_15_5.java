package d15_generics;

import java.util.ArrayList;

public class Main_15_5 {

	public static void main(String[] args) {
		
		ArrayList<Integer> siyahim=new ArrayList( );

		siyahim.add(12);
		siyahim.add(44);
		siyahim.add(125);
		siyahim.add(234);
		
		//siyahim.remove(2);
	
		System.out.println(siyahim.toString());
		//System.out.println(siyahim.get(3));
		
		ArrayList<String> siyahim2=new ArrayList( );
		siyahim2.add("Alma");
		siyahim2.add("Armud");
		siyahim2.add("Nar");
		
		System.out.println(siyahim2);
	}

}
