package com.pluralsight.payroll;

import java.io.*;
import java.lang.management.PlatformLoggingMXBean;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class GetPayroll {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The name of the file to process: ");
        String userInput = scanner.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String payInput = scanner.nextLine();

        PayrollCalculator p = null;

        try (FileReader employeeReader = new FileReader("./src/main/resources/employees.csv");
        BufferedReader bufferedReader = new BufferedReader(employeeReader)) {
            bufferedReader.readLine();
        if (userInput.equalsIgnoreCase("employees.csv")){
            String input;

            while((input = bufferedReader.readLine()) !=null) {
                String[] employeeParts = input.split("\\|");
                int id = Integer.parseInt(employeeParts[0]);
                String name = employeeParts[1];
                double hoursWorked = Double.parseDouble(employeeParts[2]);
                double payRate = Double.parseDouble(employeeParts[3]);

                p = new PayrollCalculator(id, name, hoursWorked, payRate);
                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                        p.getId(), p.getName(), p.getGrossPay());
            }
            }
        } catch (IOException e) {
            System.err.println("Error reading the employee file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing employee data: " + e.getMessage());
        }
        if (payInput.equalsIgnoreCase("payroll-sept-2023.csv")) {
           try (FileWriter fileWriter = new FileWriter("./src/main/resources/payroll-sept-2023.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
               bufferedWriter.write("id|name|gross pay");
               bufferedWriter.newLine();

               // Write payroll dat
               System.out.println("Payroll file created successfully.");

           } catch (IOException e) {
               System.err.println("Error writing the payroll file: " + e.getMessage());
           }



        }

    }








        //PayrollCalculator[] employee = new PayrollCalculator[4];



        //bufferedWriter.close();
    }

