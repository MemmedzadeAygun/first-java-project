package Array.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main34 {

	public static void main(String[] args) {
		  
		Integer[] massiv= {14,564,233,453,876,123};
		
		List<Integer> list=Arrays.asList(massiv);
		System.out.println(list);

//		for(Integer i:list) {
//			if(i%2==0) {
//				System.out.println(i);
//			}
//		}
		
		list.stream().filter(e->e%2==0).forEach(System.out::println);
		List<Integer> result=list.stream().filter(e->e%2==0).map(e->e*5).collect(Collectors.toList());
		System.out.println(result);
	}

}
