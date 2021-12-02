package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int depth = 0;
            int horizontal = 0;
            int aim = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int numberOnly = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                if(line.contains("forward")){
                    horizontal += numberOnly;
                    depth += aim * numberOnly;
                }
                else if(line.contains("up")){
                 //   depth -= numberOnly;
                    aim -= numberOnly;
                }
                else if(line.contains("down")){
                   // depth += numberOnly;
                    aim += numberOnly;
                }
            }
            int finalResult = depth * horizontal;
            System.out.println("The end result is:" + finalResult);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
