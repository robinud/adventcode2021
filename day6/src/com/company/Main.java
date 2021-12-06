package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> lanturnFish = new ArrayList<>();
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String[] numbers = myReader.nextLine().split(",");
                for(String number: numbers){
                    lanturnFish.add(Integer.parseInt(number));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int counter = 0;
        while (counter < 80){
            ArrayList<Integer> newLanturnFishList = new ArrayList<>();
            for(Integer timer: lanturnFish){
                if(timer == 0){
                    newLanturnFishList.add(6);
                    newLanturnFishList.add(8);
                }
                else {
                    newLanturnFishList.add(--timer);
                }
            }
            lanturnFish = newLanturnFishList;
            counter++;
        }
        System.out.println("The end result is:"+ lanturnFish.size());
    }
}
