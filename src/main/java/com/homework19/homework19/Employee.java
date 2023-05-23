package com.homework19.homework19;

public class Employee {
    private final Integer id;
    private String fullName;
    private int department;
    private int salary;
    private static Integer idCounter = 1;


    public Employee(String fullname, int department, int salary) {
        this.id = idCounter++;
        this.fullName = fullname;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public int hashCode() {
        return java.util.Objects.hash(fullName, department, salary, id);
    }

    public String toString() {
        return "ID: " + id + "; " +
                "Имя сотрудника - " + this.fullName + "; " +
                "Номер отдела: " + this.department + "; " +
                "Зарплата в месяц: " + this.salary;
    }
}

