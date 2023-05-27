package com.homework19.homework19;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceIntf{
    private List<Employee> employees;
    private static final int MAX_EMPLOYEES = 50;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник " + firstName + " " + lastName + " уже добавлен.");
            }
        }

        Employee newEmployee = new Employee(firstName, lastName);
        employees.add(newEmployee);
        System.out.println("Сотрудник " + firstName + " " + lastName + " добавлен.");
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Сотрудник " + firstName + " " + lastName + " удален.");
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
        }
        return employeeToRemove;
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
    }
    @Override
    public List<Employee> employees() {
        return employees();
    }

}
