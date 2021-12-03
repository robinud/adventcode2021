package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
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
}
