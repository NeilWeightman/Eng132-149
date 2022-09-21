package org.sparta.collections;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private String department;

    public static List<Employee> getEmployeesList() {
        return new ArrayList<>(List.of(
                new Employee("Houssam", "Bououdina", "Sales"),
                new Employee("Andrei", "Cravtov", "Management"),
                new Employee("Bilal", "Hamid", "Development"),
                new Employee("Meet", "Vaghela", "Sales"),
                new Employee("Olegs", "Maklecovs", "Development"),
                new Employee("Abdullah", "Abdullah", "Sales"),
                new Employee("Luca", "Cooper-Lindsay", "Testing"),
                new Employee("Dan", "Booth", "Development"),
                new Employee("Bahadir", "Bektas", "Sales"),
                new Employee("Joshua", "Jackson", "Management"),
                new Employee("Goncalo", "Barros", "Sales"),
                new Employee("Daniils", "Beilins", "Testing"),
                new Employee("Lovedeep", "Saini", "Development"),
                new Employee("Hammad", "Anwar", "Testing"),
                new Employee("Pavitar", "Singh", "Sales"),
                new Employee("Daniel", "Nenov", "Management"),
                new Employee("Malek", "Busari", "Sales"),
                new Employee("Ali", "Zahir", "Development"),
                new Employee("Yannan", "Mao", "Testing"),
                new Employee("Maddy", "McMurray", "Sales"),
                new Employee("Andrei", "Hirleata", "Testing"),
                new Employee("Adam", "Lemdani", "Management")
        ));
    }

    public int compareTo(Employee otherEmployee){
        return this.lastName.length() - otherEmployee.lastName.length();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
