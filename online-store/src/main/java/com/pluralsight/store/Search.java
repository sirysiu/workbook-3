package com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {


    public Search() {

        //ArrayList<Products> productsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        if (searchTerm.equalsIgnoreCase("name")) ;
        {

            try (FileReader fileReader = new FileReader("./src/main/resources/products.csv");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                bufferedReader.readLine();

                String userInput;
                while ((userInput = bufferedReader.readLine()) != null) {
                    String[] productParts = userInput.split("\\|");
                    String sku = productParts[0];
                    String name = productParts[1];
                    double prices = Double.parseDouble(productParts[2]);
                    String department = productParts[3];
                    Products products = new Products(sku, name, prices, department);
                    System.out.printf("Product Name: %s%n", products.getName());

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
