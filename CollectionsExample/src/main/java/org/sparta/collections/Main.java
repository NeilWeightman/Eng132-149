package org.sparta.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new LinkedList<>(List.of("Olegs", "Lovedeep", "Daniils"));
//        myList.add("Olegs");
//        myList.add("Lovedeep");
//        myList.add("Daniils");
        myList.add(1, "Hassaan");
        myList.add("Hassaan");
        // not allowed because myList is a list of Strings
//        myList.add(new Employee("Neil", "Weightman", "Training"));
        for(int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));
        List<Employee> empList = Employee.getEmployeesList();
//        Collections.sort(empList);
        // define an anonymous inner class and instantiating it
//        empList.sort(new Comparator<>(){
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getFirstName().compareTo(o2.getFirstName());
//            }
//        });
        // yikes! using lambda expression
//        empList.sort((o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        Comparator<Employee> myComp
                = (o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        empList.sort(myComp);
        System.out.println(empList);
    }
}