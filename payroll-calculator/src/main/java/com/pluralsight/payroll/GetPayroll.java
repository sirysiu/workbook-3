package com.pluralsight.payroll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;


public class GetPayroll {
    public static void main(String[] args) throws IOException {

        PayrollCalculator p;

        FileReader employeeReader = new FileReader("./src/main/resources/employees.csv");
        BufferedReader bufferedReader = new BufferedReader(employeeReader);
        bufferedReader.readLine();
        String input;

        PayrollCalculator[] employee = new PayrollCalculator[4];

        while((input =bufferedReader.readLine()) !=null)
        {
            String[] employeeParts = input.split("\\|");
            int id = Integer.parseInt (employeeParts[0]);
            String name = employeeParts[1];
            double hoursWorked = Double.parseDouble (employeeParts [2]);
            double payRate = Double.parseDouble (employeeParts[3]);
            p = new PayrollCalculator(id, name, hoursWorked, payRate);

            System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                    p.getId(), p.getHoursWorked(), p.getGrossPay());
        }


    }
}
