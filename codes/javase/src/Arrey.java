import java.util.Scanner;

public class Arrey {

	public static void main(String[] args) {
		
		String[] arrey=new String[3];
		Scanner a=new Scanner(System.in);
		
		for(int i=0; i<arrey.length;i++) {
			System.out.println(""+(i+1)+"ci adi yaz");
			arrey[i]=a.nextLine();
		}
		a.close();
		
		for(String name: arrey) {
			System.out.println(name);
		}
	}
	
}
