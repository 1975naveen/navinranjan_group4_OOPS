package com.itsupport;

import java.util.Scanner;

import com.itsupport.model.EmployeeDetails;
import com.itsupport.service.CredentialGenerator;

public class OnBoardingController {

	public static void main(String[] args) {
		EmployeeDetails employeeDetails = new EmployeeDetails("Navin", "Ranjan");
		CredentialGenerator credentialGenerator = new CredentialGenerator();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the department from the following ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		String generatedEmail = null;
		String generatedPassword = null;
		
		boolean isValidInput = true;
		do {
			int deptName = scanner.nextInt();
			switch (deptName) {

			case 1: {
				generatedEmail = credentialGenerator.generateEmailAddress(employeeDetails.getFirstName().toLowerCase(),
						employeeDetails.getLastName().toLowerCase(), "tech");
				generatedPassword = credentialGenerator.generatePassword();
				isValidInput = true;
				break;
			}
			case 2: {
				generatedEmail = credentialGenerator.generateEmailAddress(employeeDetails.getFirstName().toLowerCase(),
						employeeDetails.getLastName().toLowerCase(), "adm");
				generatedPassword = credentialGenerator.generatePassword();
				isValidInput = true;
				break;
			}
			case 3: {
				generatedEmail = credentialGenerator.generateEmailAddress(employeeDetails.getFirstName().toLowerCase(),
						employeeDetails.getLastName().toLowerCase(), "hr");
				generatedPassword = credentialGenerator.generatePassword();
				isValidInput = true;
				break;
			}
			case 4: {
				generatedEmail = credentialGenerator.generateEmailAddress(employeeDetails.getFirstName().toLowerCase(),
						employeeDetails.getLastName().toLowerCase(), "lg");
				generatedPassword = credentialGenerator.generatePassword();
				isValidInput = true;
				break;
			}
			default: {
				isValidInput = false;
				System.out.println("Enter a valid option");
			}
			}
		} while (!isValidInput);

		scanner.close();
		
		employeeDetails.setEmailId(generatedEmail);
		employeeDetails.setPassword(generatedPassword);
		credentialGenerator.showCredentials(employeeDetails); 
	}

}
