package com.pluralsight.store;

import java.io.*;
import java.nio.Buffer;
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
        Search search = new Search();
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
                String sku = "";
                while ((userInput = bufferedReader.readLine()) != null) {
                    String[] productParts = userInput.split("\\|");
                    sku = productParts[0];
                    String name = productParts[1];
                    double prices = Double.parseDouble(productParts[2]);
                    String department = productParts[3];
                    products = new Products(sku, name, prices, department);
                    System.out.printf("Sku: %s, Name: %s, Price: %.2f, Department: %s%n",
                            products.getSku(), products.getName(), products.getPrice(), products.getDepartment());
                }


                System.out.println("Enter Sku to add to Cart (back to return): ");
                String skuInput = scanner.nextLine();


                if (skuInput.equalsIgnoreCase(sku)) {
                    search.addProduct(products);
                    System.out.println(products.getName() + "added to cart. ");
                }

//                    for (Products searchProduct : productsList) {
//                        if (searchProduct.getSku().equals(skuInput)) {
//                            search.addProduct(searchProduct);
//                            System.out.println(products.getName() + "added to cart. ");
//
//                        }
//                    }


//


            }  if (input == 2) {
                search.displayCart();

//                searchAction("launch");
//                String searchTerm;
//
//                do {
//                    displayCart();
//                    System.out.println("""
//
//                            To Remove [R] || Exit [X] || Display Cart [D]
//
//                            Otherwise enter items:
//
//                            """);
//                    searchTerm = scanner.nextLine();
//
//                    if (searchTerm.equalsIgnoreCase("R")){
//                        removeLastLog();
//                        System.out.println("All items Removed");
//                    }
//                  else if (!searchTerm.equalsIgnoreCase("x")) {
//                        searchAction("Item added: " + searchTerm);
//                    }
//                } while (!searchTerm.equalsIgnoreCase("X"));
//
//                searchAction("exit");
            }
            if (input == 3) {
                System.out.println("You are Exited");
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
    private static void displayCart() {
        System.out.println("Current Cart: ");
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void removeLastLog() {
        ArrayList<String> cartItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE))){
            String line;
            while ((line = reader.readLine()) !=null) {
                cartItems.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!cartItems.isEmpty()) {
            cartItems.remove(cartItems.size() - 1);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE))) {
                for (String cart : cartItems) {
                    writer.write(cart);
                    writer.newLine();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

