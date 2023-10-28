package pass_by_reference;

public class MainClass {

	public static void main(String[] args) {
		
		Person a=new Person("Jale","Memmedov","(050)000-00-00",3);
		
		SalaryCalculator b=new SalaryCalculator();
		b.calculateSalary(a);
		a.printInfo();
	}

}
