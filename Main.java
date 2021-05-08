package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee emp1 = new Employee("Jan","Kowalski", "xyz");
        System.out.println(emp1.getEmployeeNumber());
        Employee emp2 = new Employee("Mateusz","Nowak", "xyz2");
        System.out.println(emp2.getEmployeeNumber());
        Employee emp3 = new Employee("Adrian","Kwiatkowski", "xyz3");
        System.out.println(emp3.getEmployeeNumber());
        Employee emp4 = new Employee("Maciej","Nowakowski", "xyz4");
        System.out.println(emp4.getEmployeeNumber());
        Employee emp5 = new Employee("Magdalena","Kowalska", "xyz5");
        Employee emp6 = new Employee("Barbara","Kwiatkowska", "xyz6");
        emp1.activateEmployee(emp1);
        emp2.activateEmployee(emp2);
        emp3.activateEmployee(emp3);
        emp4.activateEmployee(emp4);
        emp1.addEmployee(emp1);
        emp2.addEmployee(emp2);
        emp3.addEmployee(emp3);

        emp1.showInfo(emp1);
        emp2.showInfo(emp2);
        emp3.showInfo(emp3);
        emp4.showInfo(emp4);
        emp5.showInfo(emp5);
        emp6.showInfo(emp6);

        emp1.employeesStatus();


    }
}

class Employee{
    private static int employeeNumber;
    private int activeEmployees;
    private String firstName;
    private String lastName;
    private String login;
    private boolean isActive=false;
    private static List<Employee> employees = new ArrayList<>();

    public Employee(String firstName, String lastName, String login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.isActive=false;
        this.employeeNumber=employeeNumber++;
        employeeNumber++;
    }


    public void activateEmployee(Employee employee){
        this.isActive=true;
    }

    public void deactivateEmployee(Employee employee){
        this.isActive=false;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
    }

    public void showInfo(Employee employee){
        System.out.println(String.format("First name: %s, last name: %s, login: %s, Is active?: %b, employee id: %d", this.firstName, this.lastName, this.login, isActive, employeeNumber));
    }

    public static int getEmployeeNumber() {
        return employeeNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void employeesStatus(){
        int activeEmployees=1;
        for(Employee employee:employees){
            if (isActive==true){
                activeEmployees++;
            }
        }
        System.out.println("Employees: "+employeeNumber+" Active employees: "+activeEmployees);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }
}
