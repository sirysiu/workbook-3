package com.pluralsight.format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
      LocalDateTime today = LocalDateTime.now();

      DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm:ss");
      String formattedDate = today.format(fmt);
        System.out.println("Today is: " + formattedDate);

      DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String formattedDate1 = today.format(fmt1);
        System.out.println("Today is: "+ formattedDate1);

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted2 = today.format(fmt2);
        System.out.println("Today is: " + formatted2);

        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatted3 = today.format(fmt3);
        System.out.println("Today is: "+ formatted3 );

        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("hh:mm, 'on' dd-MMM-yyyy");
        String formatted4 = today.format(fmt4);
        System.out.println("Challenge is: " + formatted4);


    }


}
