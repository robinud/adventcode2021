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
            ArrayList<Integer> crabPositions = new ArrayList<>();
            int highestPosition = 0;
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(",");
                for(String crabPosition: line){
                    crabPositions.add(Integer.parseInt(crabPosition));
                    if(Integer.parseInt(crabPosition) > highestPosition) highestPosition = Integer.parseInt(crabPosition);
                }
            }
            HashMap<Integer, Long> sumMovement = new HashMap<>();
            for(int i=0; i< highestPosition; i++){
                for(int position: crabPositions){
                    if(sumMovement.containsKey(i)){
                        //puzzle 1
                        //sumMovement.replace(i,sumMovement.get(i) + Long.valueOf(Math.abs(position-i)));
                        sumMovement.replace(i,sumMovement.get(i) + calculateFuel(position,i));
                    }
                    else {
                        //puzzle 1
                        //sumMovement.put(i, Long.valueOf(Math.abs(position-i)));
                        sumMovement.put(i, calculateFuel(position,i));
                    }
                }
            }
            long leastFuel = sumMovement.get(0);
            for(Long sum: sumMovement.values()){
                if(sum < leastFuel){
                    leastFuel = sum;
                }
            }
            System.out.println("The least amount of fuel is:" + leastFuel);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static Long calculateFuel(int position, int endPosition) {
        int difference = Math.abs(position - endPosition);
        long endResult = 0;
        for(int i =0; i< difference; i++){
            endResult += 1 + (1* i);
        }
        return endResult;
    }
}
