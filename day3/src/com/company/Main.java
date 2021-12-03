package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public void puzzle1(){
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int[] zeroCounters = new int[12];
            int[] oneCounters = new int[12];
            while (myReader.hasNextLine()) {
                String binaryCode = myReader.nextLine();
                for(int i=0; i < binaryCode.length(); i++){
                    if(binaryCode.charAt(i) == '0'){
                        zeroCounters[i] += 1;
                    }
                    else if(binaryCode.charAt(i) == '1'){
                        oneCounters[i] += 1;
                    }
                }
            }
            String gammaBinary = "";
            String epsilonBinary = "";
            for(int i = 0; i< zeroCounters.length; i++){
                if(zeroCounters[i] > oneCounters[i]){
                    gammaBinary += "0";
                    epsilonBinary += "1";
                }
                else {
                    gammaBinary += "1";
                    epsilonBinary += "0";
                }
            }
            int finalGamma = Integer.parseInt(gammaBinary,2 );
            int finalEpsilon = Integer.parseInt(epsilonBinary, 2);
            System.out.println("The end result is:" + finalEpsilon * finalGamma);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> removeBinaries(ArrayList<String> list, int binaryCode, int index){
        if(list.size() == 1){
            return list;
        }
        ArrayList<String> newValues = new ArrayList<>();
        for(String code: list){
            if(!(code.charAt(index) == Character.forDigit(binaryCode, 10))){
                newValues.add(code);
            }
        }
        return newValues;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            ArrayList<String> binaryCodes = new ArrayList();
            int[] zeroCounters = new int[12];
            int[] oneCounters = new int[12];
            while (myReader.hasNextLine()) {
                String binaryCode = myReader.nextLine();
                binaryCodes.add(binaryCode);
                for(int i=0; i < binaryCode.length(); i++){
                    if(binaryCode.charAt(i) == '0'){
                        zeroCounters[i] += 1;
                    }
                    else if(binaryCode.charAt(i) == '1'){
                        oneCounters[i] += 1;
                    }
                }
            }
            ArrayList<String> oxygen = binaryCodes;
            ArrayList<String> co2 = binaryCodes;
            for(int i = 0; i< zeroCounters.length; i++){
                boolean hasMoreZeroesOxygen = countBinary(oxygen, i);
                boolean hasMoreZeroesCo2 = countBinary(co2, i);
                if(hasMoreZeroesOxygen){
                    oxygen = removeBinaries(oxygen, 1, i);
                }
                else{
                    oxygen = removeBinaries(oxygen, 0, i);
                }
                if(hasMoreZeroesCo2){
                    co2 = removeBinaries(co2, 0, i);
                }
                else {
                    co2 = removeBinaries(co2, 1, i);
                }
            }
            int finalOxygen = Integer.parseInt(oxygen.get(0),2 );
            int finalCo2 = Integer.parseInt(co2.get(0), 2);
            System.out.println("The end result is:" + finalOxygen * finalCo2);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean countBinary(ArrayList<String> list, int index) {
        int zeroCounter = 0;
        int oneCounter = 0;
        for(String code: list){
            if((code.charAt(index) == Character.forDigit(0, 10))){
                zeroCounter++;
            }
            else{
                oneCounter++;
            }
        }
        return zeroCounter > oneCounter;
    }

}
