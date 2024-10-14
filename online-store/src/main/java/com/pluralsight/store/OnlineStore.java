package com.pluralsight.store;

import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class OnlineStore {
    public static void main(String[] args) {

        Products products = null;
        ArrayList<Products> productsList = new ArrayList<>();
        Search search;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                =====================
                The Store Home Screen
                =====================
                [1] Display Products
                [2] Display Carts
                [3] Exit 
                """);
        int input = scanner.nextInt();
        scanner.nextLine();

        try (FileReader fileReader = new FileReader("./src/main/resources/products.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.readLine();

            if (input == 1) {
                String userInput;
                while ((userInput = bufferedReader.readLine()) != null) {
                    String[] productParts = userInput.split("\\|");
                    String sku = productParts[0];
                    String name = productParts[1];
                    double prices = Double.parseDouble(productParts[2]);
                    String department = productParts[3];
                    products = new Products(sku, name, prices, department);
                    System.out.printf("Sku: %s, Name: %s, Price: %.2f, Department: %s%n",
                            products.getSku(), products.getName(), products.getPrice(), products.getDepartment());
                }
                System.out.println("\nType to search or exit[x]? ");
                String inputSearch = scanner.nextLine();
                search = new Search();
                if (inputSearch.equalsIgnoreCase("name"));
                {
                    System.out.println(search);
                }


        }  if (input == 2) {
                searchAction("launch");
                String searchTerm;

                do {
                    System.out.println("Nothing At the moment. Please add item: ");
                    searchTerm = scanner.nextLine();

                    if (!searchTerm.equalsIgnoreCase("x")) {
                        searchAction("Item added: " + searchTerm);
                    }
                } while (!searchTerm.equalsIgnoreCase("X"));

                searchAction("exit");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String CART_FILE = "./src/main/resources/cart.txt";

    private static void searchAction(String action) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String searchEntry = timeStamp + " " + action;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE, true))) {
            writer.write(searchEntry);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

