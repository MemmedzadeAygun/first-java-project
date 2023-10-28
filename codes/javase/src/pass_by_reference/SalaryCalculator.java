package pass_by_reference;

public class SalaryCalculator {
	
	 void calculateSalary(Person person) {
		 person.salary=person.experienceYear*500;
	}
}
