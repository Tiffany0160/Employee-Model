package service;

import model.Employee;
import java.util.ArrayList;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            emp.display();
        }
    }

    public Employee searchEmployee(int id) {

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }

    public void deleteEmployee(int id) {

        Employee emp = searchEmployee(id);

        if (emp != null) {
            employees.remove(emp);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployee(int id, String name, String position, double salary) {

        Employee emp = searchEmployee(id);

        if (emp != null) {
            emp.setName(name);
            emp.setPosition(position);
            emp.setSalary(salary);
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}