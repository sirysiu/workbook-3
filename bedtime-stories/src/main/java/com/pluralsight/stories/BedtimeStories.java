package com.pluralsight.stories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                           Please Choose A Story:
                           goldilocks.txt
                           hansel_and_gretel.txt
                           mary_had_a_little_lamb.txt
                    """);

        String inputStory = scanner.nextLine();

        String filePath = "./src/main/resources/" + inputStory;

            try (FileInputStream fis = new FileInputStream(filePath);
                 Scanner fileScanner = new Scanner(fis)) {

                System.out.println("Reading story: " + inputStory);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);

                }
            } catch (FileNotFoundException e) {
                System.out.println("Story not found: " + inputStory);
            } catch (IOException e) {
                throw new RuntimeException(e);

}
    }
}