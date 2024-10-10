package com.pluralsight.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SearchEngineLogger {

    private static final String LOG_FILE = "./src/main/resources/logs.txt";

    public static void main(String[] args) {
        // Log the application launch
        logAction("launch");

        Scanner scanner = new Scanner(System.in);
        String searchTerm;

        do {
            System.out.print("Enter a search term (X to exit): ");
            searchTerm = scanner.nextLine();

            if (!searchTerm.equalsIgnoreCase("X")) {
                logAction("search : " + searchTerm);
            }
        } while (!searchTerm.equalsIgnoreCase("X"));

        // Log the exit action
        logAction("exit");

        scanner.close();
    }

    private static void logAction(String action) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = timestamp + " " + action;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
