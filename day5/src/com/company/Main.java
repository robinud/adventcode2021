package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int[] pointsCounter = new int[1000 * 1000];
            int counter =0;
            while (myReader.hasNextLine()) {
               String[] positions = myReader.nextLine().split(" -> ");
               int x1 = Integer.parseInt(positions[0].split(",")[0]);
               int x2 = Integer.parseInt(positions[1].split(",")[0]);
               int y1 = Integer.parseInt(positions[0].split(",")[1]);
               int y2 = Integer.parseInt(positions[1].split(",")[1]);
               int deltaX = x2-x1;
               int deltaY = y2-y1;

                int difference = deltaX == 0 ? Math.abs(deltaY) : Math.abs(deltaX);
                deltaX = Integer.signum(deltaX);
                deltaY = Integer.signum(deltaY);

                for (int i = 0; i <= difference; i++) {
                    counter += pointsCounter[(y1 + deltaY * i) * 1000 + (x1 + deltaX * i)]++ == 1 ? 1 : 0;
                }
            }
            System.out.println("The final result is: " + counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void partOne(){
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int[] pointsCounter = new int[1000 * 1000];
            int counter =0;
            while (myReader.hasNextLine()) {
                String[] positions = myReader.nextLine().split(" -> ");
                int x1 = Integer.parseInt(positions[0].split(",")[0]);
                int x2 = Integer.parseInt(positions[1].split(",")[0]);
                int y1 = Integer.parseInt(positions[0].split(",")[1]);
                int y2 = Integer.parseInt(positions[1].split(",")[1]);
                int deltaX = x2-x1;
                int deltaY = y2-y1;
                if(deltaX != 0 && deltaY != 0){
                    continue;
                }
                int difference = deltaX == 0 ? Math.abs(deltaY) : Math.abs(deltaX);
                deltaX = Integer.signum(deltaX);
                deltaY = Integer.signum(deltaY);

                for (int i = 0; i <= difference; i++) {
                    counter += pointsCounter[(y1 + deltaY * i) * 1000 + (x1 + deltaX * i)]++ == 1 ? 1 : 0;
                }
            }
            System.out.println("The final result is: " + counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




}
