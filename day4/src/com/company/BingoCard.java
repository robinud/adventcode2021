package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class BingoCard {

    public int[][] numbers = new int[5][5];
    public HashMap<String, Boolean> isRolled = new HashMap();

    public BingoCard(ArrayList<Integer> numbersCard) {
        int counter =0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                numbers[i][j] = numbersCard.get(counter);
                isRolled.put(String.valueOf(numbersCard.get(counter)), false);
                counter++;
            }
        }
    }

    public boolean checkBingo(int number) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
               if(isRolled.containsKey(String.valueOf(number)) ){
                   isRolled.replace((String.valueOf(number)),true);
                   if(checkVertical()) return true;
                   if(checkHorizontal())return true;
                   break;
               }
            }
        }

        return false;
    }

    private boolean checkHorizontal() {
        boolean hasBingo = false;
        int counter =0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(isRolled.get(String.valueOf(numbers[i][j]))){
                    hasBingo = true;
                    counter++;
                    continue;
                }
                hasBingo =false;
                counter = 0;
                break;
            }
            if(counter == 5){
                break;
            }
        }
        return hasBingo;
    }

    private boolean checkVertical() {
        boolean hasBingo = false;
        int counter = 0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(isRolled.get(String.valueOf(numbers[j][i]))){
                   hasBingo = true;
                   counter++;
                    continue;
                }
                hasBingo =false;
                counter =0;
                break;
            }
            if(counter == 5){
                break;
            }
        }
        return hasBingo;
    }

    public int getSum(){
        int sum = 0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!isRolled.get(String.valueOf(numbers[i][j]))) {
                    sum += numbers[i][j];
                }
            }
        }
        return sum;
    }
}
