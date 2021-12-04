package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbersOrder = new ArrayList<>();
        ArrayList<BingoCard> cards  = new ArrayList<>();
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                if(numbersOrder.size() == 0){
                    String line = myReader.nextLine();
                    String[] numbers = line.split(",");
                    for(String number: numbers){
                        numbersOrder.add(Integer.parseInt(number));
                    }
                }
                else {
                    ArrayList<Integer> numbersCard = new ArrayList<>();
                    String bingoLine = myReader.nextLine();
                    do {
                        bingoLine = bingoLine.replaceAll(" +", " ").trim();
                        String[] numbers = bingoLine.split("\\s");
                        if (!bingoLine.equals("")) {
                            for (String number : numbers) {
                                numbersCard.add(Integer.parseInt(number));
                            }
                        }
                        if(myReader.hasNextLine()) {
                            bingoLine = myReader.nextLine();
                        }
                        else bingoLine ="";
                    } while (!bingoLine.equals(""));
                    cards.add(new BingoCard(numbersCard));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean hasBingo = false;
        BingoCard winningCard = null;
        int winningNumber =0;
        Set<BingoCard> lastOne = new HashSet<>();
        for(int number: numbersOrder){
            for(BingoCard card: cards){
                if(card.checkBingo(number)){
                    if(lastOne.size() == 100){
                        hasBingo = true;
                        winningCard = card;
                        winningNumber =number;
                        break;
                    }
                    lastOne.add(card);
                }
            }
            if(hasBingo) break;
        }
        int sum = winningCard.getSum();
        System.out.println("The end result is:" + winningNumber * sum);
    }

    public void part1(){
        ArrayList<Integer> numbersOrder = new ArrayList<>();
        ArrayList<BingoCard> cards  = new ArrayList<>();
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                if(numbersOrder.size() == 0){
                    String line = myReader.nextLine();
                    String[] numbers = line.split(",");
                    for(String number: numbers){
                        numbersOrder.add(Integer.parseInt(number));
                    }
                }
                else {
                    ArrayList<Integer> numbersCard = new ArrayList<>();
                    String bingoLine = myReader.nextLine();
                    do {
                        bingoLine = bingoLine.replaceAll(" +", " ").trim();
                        String[] numbers = bingoLine.split("\\s");
                        if (!bingoLine.equals("")) {
                            for (String number : numbers) {
                                numbersCard.add(Integer.parseInt(number));
                            }
                        }
                        if(myReader.hasNextLine()) {
                            bingoLine = myReader.nextLine();
                        }
                        else bingoLine ="";
                    } while (!bingoLine.equals(""));
                    cards.add(new BingoCard(numbersCard));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean hasBingo = false;
        BingoCard winningCard = null;
        int winningNumber =0;
        for(int number: numbersOrder){
            for(BingoCard card: cards){
                if(card.checkBingo(number)){
                    hasBingo = true;
                    winningCard = card;
                    winningNumber =number;
                    break;
                }
            }
            if(hasBingo) break;
        }
        int sum = winningCard.getSum();
        System.out.println("The end result is:" + winningNumber * sum);
    }
}
