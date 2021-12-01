package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input1.txt");
            Scanner myReader = new Scanner(input);
            int counter = 0;
            int previousValue = 0;
            while (myReader.hasNextLine()) {
                int currentValue = Integer.parseInt(myReader.nextLine());
                if(currentValue > previousValue && previousValue != 0){
                    counter++;
                }
                previousValue = currentValue;
            }
            System.out.println("The end result is:" + counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
