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
                isRolled.put(String.valueOf(i) + String.valueOf(j), false);
                counter++;
            }
        }
    }

    public boolean checkBingo(int number) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
               if(numbers[i][j] == number ){
                   isRolled.replace((String.valueOf(i) + String.valueOf(j)),true);
               }
            }
        }
        if(checkHorizontal()) return true;
        if(checkVertical())return true;
        return false;
    }

    private boolean checkVertical() {
        boolean hasBingo = false;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(isRolled.get((String.valueOf(j) + String.valueOf(i)))){
                    hasBingo = true;
                    continue;
                }
                hasBingo =false;
                break;
            }
        }
        return hasBingo;
    }

    private boolean checkHorizontal() {
        boolean hasBingo = false;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(isRolled.get((String.valueOf(i) + String.valueOf(j)))){
                   hasBingo = true;
                    continue;
                }
                hasBingo =false;
                break;
            }
        }
        return hasBingo;
    }

    public int getSum(){
        int sum = 0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!isRolled.get((String.valueOf(i) + String.valueOf(j)))) {
                    sum += numbers[i][j];
                }
            }
        }
        return sum;
    }
}
