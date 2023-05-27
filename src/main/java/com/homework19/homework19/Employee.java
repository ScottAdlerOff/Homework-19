package com.homework19.homework19;

public class Employee {
    private String firstName;
    private String lastName;



    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }

    public String toString() {
        return "Имя сотрудника - " + this.firstName +
                "Фамилия сотрудника: " + this.lastName;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }
}

