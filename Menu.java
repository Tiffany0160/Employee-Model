package ui;

import service.EmployeeService;
import model.Employee;
import java.util.Scanner;

public class Menu {

    private EmployeeService service = new EmployeeService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addEmployee() {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, position, salary);
        service.addEmployee(emp);
    }

    private void searchEmployee() {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        Employee emp = service.searchEmployee(id);

        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void updateEmployee() {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Position: ");
        String position = scanner.nextLine();

        System.out.print("New Salary: ");
        double salary = scanner.nextDouble();

        service.updateEmployee(id, name, position, salary);
    }

    private void deleteEmployee() {

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        service.deleteEmployee(id);
    }
}