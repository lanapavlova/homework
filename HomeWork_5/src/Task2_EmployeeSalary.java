import java.util.Scanner;

class Employee {

	String name;
	private int salary;
	String position;
	String department;
	int age;
	String email;

	public Employee(String name, int salary, String position, String department) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
	}

	public Employee(String name, int salary, String position, String department, int age) {
		this(name, salary, position, department);
		this.age = age;
	}

	public Employee(String name, int salary, String position, String department, String email) {
		this(name, salary, position, department);
		this.email = email;
	}

	public Employee(String name, int salary, String position, String department, int age,
			String email) {
		this(name, salary, position, department);
		this.age = age;
		this.email = email;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printEmployee(){
		System.out.println(this.name + ", " + this.department + ", "  + this.position + ", " + this.email);
		
	}
	
	public static Employee [] sortDescEmployeeBySalary(Employee [] employee) {
		int i, j; 
		Employee valueEmployee;
		
		for (i = 1; i < employee.length; i++) {
			valueEmployee = employee[i];
			for(j = i-1; (j >= 0) && (employee[j].salary < valueEmployee.salary); j--) {
				employee[j+1]= employee[j];
			}
			
			employee[j+1] = valueEmployee;
		}
		
		return employee;
	}
}

public class Task2_EmployeeSalary {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		sc.nextLine();
		
		Employee[] employeeArray = new Employee[size];
		
		for (int i = 0; i < employeeArray.length; i++) {
			System.out.println("Enter name please!");
			String name = sc.nextLine();
			
			System.out.println("Enter salary please!");
			int salary = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter position please!");
			String position = sc.nextLine();
			
			System.out.println("Enter department please!");
			String department = sc.nextLine();
			
			System.out.println("Enter age please!");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter e-mail please!");
			String email = sc.nextLine();
			
			employeeArray[i] = new Employee(name, salary, position, department, age, email);
		}
		
		Employee.sortDescEmployeeBySalary(employeeArray);
		
		for (int i = 0; i < 3; i++) {
			employeeArray[i].printEmployee();
		}
		sc.close();
	}
}