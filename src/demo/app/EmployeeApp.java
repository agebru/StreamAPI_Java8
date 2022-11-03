package demo.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeApp {

	public static void main(String[] args) {
		List<String> addressList=Arrays.asList("Address 1","Address 2");
		System.out.println("AddressList: "+addressList);
		
	//	addressList.add("Address 3");
		//System.out.println("New AddressList: "+addressList);
		
		System.out.println("Hello From: ");
		Arrays.asList("DC", "ATL", "Dallas").stream().forEach(System.out::println);

		// How many males and female employee are there in the organization

		System.out.println("Number of Male and Female Employees:");
		groupByGender();
		
		System.out.println("\nDepartments in the Organization: ");
		printNameOfDepartments();
		
		printAverageAgeMaleFemale();
		findHighestPaidEmployee();
		
		CountEmployeesInEachDepartment();
		printAverageSalaryForEachDepartment();
		printYoungestMaleEmployeeInProductDevl();
		printTheMostWorkingExperience();
		printAverageSalaryAndTotalSalary();

		
		System.out.println("Today is: "+getToday());
	}
	
	
	
	public static String getToday() {
		return LocalDate.now().getDayOfWeek().plus(0).toString();
	}

	private static void groupByGender() {
		
		Map<String, Long> noOfMaleAndFemale = 
				EmployeeService.loadEmployees()
				.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println("\t" + noOfMaleAndFemale);
		
		// Grouping Primitive Types
		List<String> fruits=Arrays.asList("Apple","Apple","Banana","Apple","Orange","Banana","Papaya");
		//Map<String, Long> fruitsCount1 = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		Map<String, Long> fruitsCount = fruits.stream().collect(Collectors.groupingBy(str->str,Collectors.counting()));
		System.out.println(fruitsCount);
	}
	
	

	private static void printAverageAgeMaleFemale() {
		Map<String, Double> averageAgeMaleAndFemale =
				EmployeeService.loadEmployees()
								.stream().
								collect(
										 Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))
										);
		System.out.println("Average Age: "+averageAgeMaleAndFemale);
	}
	
	private static void printNameOfDepartments() {
		EmployeeService.loadEmployees()
		.stream().map(Employee::getDepartment)
		.distinct().forEach(System.out::println);
	}
	
	private static void findHighestPaidEmployee() {
		// Solution 1
		Collections.sort(EmployeeService.loadEmployees(), (e1,  e2) -> (int) (e2.getSalary() - e1.getSalary()));			
		System.out.println("Highest Salaried: "+EmployeeService.loadEmployees().get(0));
		
		//solution 2
		Optional<Employee> highestPaidEmployee = EmployeeService.loadEmployees()
		.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Highest paid: "+highestPaidEmployee.get());
	}
	
	
private static void CountEmployeesInEachDepartment() {
		
		Map<String, Long> employeesInEachDept = 
				EmployeeService.loadEmployees()
				.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("\nEmployee Count By Department: \n" + employeesInEachDept);
}

private static void printAverageSalaryForEachDepartment() {
	Map<String, Double> averageSalaryForEachDepartment =
			EmployeeService.loadEmployees()
							.stream().
							collect(
									 Collectors.groupingBy(
											    Employee::getDepartment,
											    Collectors.averagingDouble(Employee::getSalary))
									);
	System.out.println("\nAverage Salary for Each Department:\n "+averageSalaryForEachDepartment);
}

private static void printYoungestMaleEmployeeInProductDevl() {
	Optional<Employee> youngestMaleInProductDevl =
			EmployeeService.loadEmployees()
							.stream()
							.filter(e->e.getGender().equals("Male")	&& e.getDepartment().equals("Product Development")
									)
							.min(Comparator.comparingInt(Employee::getAge));
	
	System.out.println("\nYoungest Employee: \n"+youngestMaleInProductDevl.get());
}

private static void printTheMostWorkingExperience() {
	Optional<Employee> mostExperienced = EmployeeService.loadEmployees()
	.stream()
	.sorted(Comparator.comparingInt(Employee::getYearOfJoining))
	.findFirst();
	
	System.out.println("\n Most Experienced Employee:\n"+mostExperienced.get());
}

private static void printAverageSalaryAndTotalSalary() {
	DoubleSummaryStatistics employeeSalaryStastics = 
			EmployeeService.loadEmployees()
			.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));
	
	System.out.println("Average Salary: "+employeeSalaryStastics.getAverage());
	System.out.println("Total Salary: "+employeeSalaryStastics.getSum());
	System.out.println("Min Salary: "+employeeSalaryStastics.getMax());
	System.out.println("Max Salary: "+employeeSalaryStastics.getMin());
	System.out.println("Countint salaried Emps: "+employeeSalaryStastics.getCount());
}

}
