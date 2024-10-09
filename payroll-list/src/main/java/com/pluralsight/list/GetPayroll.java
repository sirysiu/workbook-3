package com.pluralsight.list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPayroll {
    public static void main(String[] args) throws IOException {

        PayrollCalculator p = null;

        FileReader employeeReader = new FileReader("./src/main/resources/employees.csv");
        BufferedReader bufferedReader = new BufferedReader(employeeReader);
        //bufferedReader.readLine();
        String input = "";


        ArrayList<PayrollCalculator> s = new ArrayList<>();
        System.out.println("Print out list:");

        bufferedReader.readLine();
        while ((input = bufferedReader.readLine()) != null) {

            String[] employeeParts = input.split("\\|");
            int id = Integer.parseInt(employeeParts[0]);
            String name = employeeParts[1];
            double hoursWorked = Double.parseDouble(employeeParts[2]);
            double payRate = Double.parseDouble(employeeParts[3]);
            p = new PayrollCalculator(id, name, hoursWorked, payRate);

            s.add(p);


        }
        PayrollCalculator s1 = new PayrollCalculator(90, "sur", 12,12);
        s.add(s1);
            for (PayrollCalculator employee : s) {
            //System.out.println(s);
            System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                    employee.getId(), employee.getName(), employee.getGrossPay());
}
    }
}
