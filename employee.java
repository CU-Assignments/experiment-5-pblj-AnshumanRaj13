import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Employee implements Serializable {
private static final long serialVersionUID = 1L;
private int empID;
private String name;
private double salary;
public Employee(int empID, String name, double salary) {
this.empID = empID;
this.name = name;
this.salary = salary;
}

public int getEmpID() { return empID; }
public String getName() { return name; }
public double getSalary() { return salary; }
@Override
public String toString() {
return "EmpID: " + empID + ", Name: " + name + ", Salary: " + salary;
}
}
public class EmployeeManagement {
private static final String FILE_NAME = "employees.ser";
private static List<Employee> employeeList = new ArrayList<>();
public static void main(String[] args) {
loadEmployees(); 
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("\nMenu:");
System.out.println("1. Add Employee");
System.out.println("2. View Employees");
System.out.println("3. Delete Employee");
System.out.println("4. Exit");
System.out.print("Enter choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1:
addEmployee(scanner);
break;
case 2:
viewEmployees();
break;
case 3:
deleteEmployee(scanner);
break;
case 4:
saveEmployees();
System.out.println("Exiting program...");
scanner.close();
System.exit(0);
default:
System.out.println("Invalid choice! Try again.");
}
}
}
private static void addEmployee(Scanner scanner) {
System.out.print("Enter Employee ID: ");
int empID = scanner.nextInt();
scanner.nextLine(); 
System.out.print("Enter Employee Name: ");
String name = scanner.nextLine();
System.out.print("Enter Employee Salary: ");
double salary = scanner.nextDouble();
employeeList.add(new Employee(empID, name, salary));
saveEmployees();
System.out.println("Employee added successfully!");
private static void viewEmployees() {
if (employeeList.isEmpty()) {
System.out.println("No employees found.");
} else {
System.out.println("\nEmployee List:");
for (Employee emp : employeeList) {
System.out.println(emp);
}
}
}
private static void deleteEmployee(Scanner scanner) {
System.out.print("Enter Employee ID to delete: ");
int empID = scanner.nextInt();
boolean removed = employeeList.removeIf(emp -> emp.getEmpID() == empID);
if (removed) {
saveEmployees();
System.out.println("Employee deleted successfully.");
private static void saveEmployees() {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
oos.writeObject(employeeList);
} catch (IOException e) {
e.printStackTrace();
}
private static void loadEmployees() {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
employeeList = (List<Employee>) ois.readObject();
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
}
}
