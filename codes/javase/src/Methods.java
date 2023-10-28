
public class Methods {
	
	public static void printname(int count,String name) {
		
		for(int i=0;i<count;i++) {
			System.out.println("Name:"+" "+name);
		}
	}
	
	public static void main(String[] args) {
		
		Methods mymethods = new Methods();
		mymethods.printname(5,"Aygun");
		mymethods.printname(3,"Jale");
		mymethods.printname(2,"Meryem");
	}

}
