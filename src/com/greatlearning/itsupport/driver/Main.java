package com.greatlearning.itsupport.driver;

import com.greatlearning.itsupport.models.Employee;
import com.greatlearning.itsupport.services.CredentialService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean departmentSelected = false;
        String department = null;
        while (!departmentSelected) {
            System.out.println("Please enter the department from the following");
            System.out.println("1. Technical \n2. Admin \n3. Human Resource \n4. Legal");

            int departmentChoice = scanner.nextInt();
            switch (departmentChoice) {
                case 1:
                    department = "tech";
                    departmentSelected = true;
                    break;
                case 2:
                    department = "admin";
                    departmentSelected = true;
                    break;
                case 3:
                    department = "hr";
                    departmentSelected = true;
                    break;
                case 4:
                    department = "legal";
                    departmentSelected = true;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

        Employee employee = new Employee("Rajat", "Jain");
        employee.setDepartment(department);

        CredentialService credentialService = new CredentialService();

        employee.setEmailId(credentialService.generateEmailAddress(employee));
        employee.setPassword(credentialService.generatePassword());

        credentialService.showCredentials(employee);
    }

}
