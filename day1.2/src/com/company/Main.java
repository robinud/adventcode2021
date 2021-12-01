package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int counter = 0;
            int previousSum = 0;
            int firstValue = 0;
            int secondValue = 0;
            int thirdValue = 0;
            while (myReader.hasNextLine()) {
                thirdValue = secondValue;
                secondValue = firstValue;
                firstValue = Integer.parseInt(myReader.nextLine());
                int currentSum = firstValue + secondValue + thirdValue;
                if(currentSum > previousSum && thirdValue != 0){
                    counter++;
                }
                previousSum = currentSum;
            }
            counter--;
            System.out.println("The end result is:" + counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
