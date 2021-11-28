package com.greatlearning.itsupport.services;

import com.greatlearning.itsupport.models.Employee;

import java.util.Random;

public class CredentialService {

    Random random = new Random();

    public String generatePassword() {
        char[] passwordCharArray = new char[8];
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        //Number
        passwordCharArray[0] = numbers.charAt(random.nextInt(numbers.length()));
        //Capital Letter
        passwordCharArray[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        //Small Letter
        passwordCharArray[2] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        //special symbol
        passwordCharArray[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        for (int i = 4; i < 8; i++) {
            passwordCharArray[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return new String(passwordCharArray);
    }

    public String generateEmailAddress(Employee employee) {
        return employee.getFirstName().toLowerCase() +
                employee.getLastName().toLowerCase() + "@" + employee.getDepartment() + "." + Employee.COMPANY + ".com";
    }

    public void showCredentials(Employee employee) {
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows");
        if (employee.getEmailId() == null || employee.getEmailId().isEmpty()) {
            System.out.println("Email not generated");
        } else {
            System.out.println("Email    ---> " + employee.getEmailId());
        }

        if (employee.getPassword() == null || employee.getPassword().isEmpty()) {
            System.out.println("Password not generated");
        } else {
            System.out.println("Password ---> " + employee.getPassword());
        }
    }

}
