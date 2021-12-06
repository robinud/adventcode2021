package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<Integer, Long> fish = new HashMap<>();
        for(int timer: lanturnFish) {
            if(fish.containsKey(timer)){
                fish.replace(timer, fish.get(timer) +1);
            }
            else{
                fish.put(timer, 1L);
            }
        }
        int counter = 0;
        while (counter < 256){
            HashMap<Integer, Long> newLanturnFishList = new HashMap<>();
            for(HashMap.Entry<Integer, Long> entry : fish.entrySet()){
                if(entry.getKey() == 0){
                    if(newLanturnFishList.containsKey(6)){
                        newLanturnFishList.replace(6, newLanturnFishList.get(6) + entry.getValue());
                    }
                    else {
                        newLanturnFishList.put(6, entry.getValue());
                    }
                    if(newLanturnFishList.containsKey(8)) {
                        newLanturnFishList.replace(8, newLanturnFishList.get(8) + entry.getValue());
                    }
                    else {
                        newLanturnFishList.put(8, entry.getValue());
                    }
                }
                else {
                    if(newLanturnFishList.containsKey(entry.getKey() -1)) {
                        newLanturnFishList.replace(entry.getKey() - 1, newLanturnFishList.get(entry.getKey()-1) + entry.getValue());
                    }
                    else{
                        newLanturnFishList.put(entry.getKey() - 1, entry.getValue());
                    }
                }
            }
            fish = newLanturnFishList;
            counter++;
        }
        long result = 0;
        for(long value: fish.values()){
            result += value;
        }
        System.out.println("The end result is:"+ result);
    }
}
