package com.pluralsight.quotes;

import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    public static void main(String[] args) {
        String[] famousQuotes = {" ", "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                "In the end, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King Jr.",
                "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment. - Ralph Waldo Emerson",
                "The best way to predict the future is to create it. - Peter Drucker",
                "Life is what happens when you're busy making other plans. - John Lennon",
                "The purpose of our lives is to be happy. - Dalai Lama",
                "Get busy living or get busy dying. - Stephen King",
                "You only live once, but if you do it right, once is enough. - Mae West",
                "It is never too late to be what you might have been. - George Eliot",
                "What lies behind us and what lies before us are tiny matters compared to what lies within us. - Ralph Waldo Emerson"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean loops = true;

        while(loops) {
        System.out.println("Would you like to choose yourself (Y) or random (N)? ");
        String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                loops = false;
            }
            else if (choice.equalsIgnoreCase("y")) {
                try {
                    System.out.println("Please Select 1 - 10");
                    int input = scanner.nextInt();

                    System.out.println(famousQuotes[input]);

                } catch (Exception e) {
                    System.out.println("Invalid");
                }
            } else if (choice.equalsIgnoreCase("n")) {
                int rand = random.nextInt(10);
                System.out.println(famousQuotes[rand]);

            } else {
                System.out.println("invalid");
            }


        }
        System.out.println("All Done");
    }
}