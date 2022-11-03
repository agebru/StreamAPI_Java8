package demo.app;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	private static List<Employee> employeeList = new ArrayList<Employee>() {
		{
			add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
			add(new Employee(112, "Paul Niksu", 25, "Male", "Sales and Marketing", 2015, 13500.0));
			add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
			add(new Employee(144, "Murali Godwa", 28, "Male", "Product Development", 2014, 32500.0));
			add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));

			add(new Employee(166, "Iqbal Hussein", 43, "Male", "Security and Transport", 2016, 10500.0));
			add(new Employee(177, "Manu Sharma", 35, "Male", "Account and Finance", 2010, 27000.0));

			add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
			add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales and Marketing", 2016, 11500.0));
			add(new Employee(200, "Jaden Dough", 38, "Male", "Security and Transport", 2015, 11000.50));

			add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
			add(new Employee(222, "Nithin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
			add(new Employee(233, "Jyotti Redi", 27, "Female", "Account and Finance", 2013, 21300.0));
			add(new Employee(244, "Nocolas Den", 24, "Male", "Sales and Marketing", 2017, 10700.0));
			add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
			add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
			add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		}
	};
	
	//// using 'this' is not possible 
	public static List<Employee> loadEmployees(){
		
		return employeeList;
	}
	
	
	// using 'this' is possible 
	public void print() {
		List<Employee> list=this.employeeList;
	}
}
