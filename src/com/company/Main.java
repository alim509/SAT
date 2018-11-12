package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sf = new Scanner(new File("scores.txt"));
        int maxIndx = -1;
        String array [] = new String[2000];
        double total = 0;
        double average;
        double firstAvg = -1, secondAvg = -1, thirdAvg = -1;
        String firstSchool = "", secondSchool = "", thirdSchool = "";
        String firstPlace = "1.    ", secondPlace = "2.    ", thirdPlace = "3. ";
        String text[];

        while (sf.hasNext()) {
            maxIndx++;
            array[maxIndx] = sf.nextLine();
        }

        sf.close();

        String schoolName[] = new String [10000];
        int num1 = 0, num2 = 0, num3 = 0;

        for (int i = 1; i <= maxIndx; i++) {
            text = array[i].split("\t");
            schoolName[i] = text[1];
            if (text.length > 18) {
                num1 = Integer.parseInt(text[18]);
                num2 = Integer.parseInt(text[19]);
                num3 = Integer.parseInt(text[20]);
                average = (num1 + num2 + num3) / 3;
                total += average;
                System.out.println(schoolName[i] + ":  " + average);
                if (average > firstAvg) {
                    thirdAvg = secondAvg;
                    thirdSchool = secondSchool;
                    secondAvg = firstAvg;
                    secondSchool = firstSchool;
                    firstAvg = average;
                    firstSchool = schoolName[i];
                } else if (average > secondAvg) {
                    thirdAvg = secondAvg;
                    thirdSchool = secondSchool;
                    secondAvg = average;
                    secondSchool = schoolName[i];
                } else if (average > thirdAvg) {
                    thirdAvg = average;
                    thirdSchool = schoolName[i];
                }
            }
        }
        if (firstAvg == secondAvg) {
            firstPlace = "1.    ";
            secondPlace = "1.   ";
        } else if (secondAvg == thirdAvg) {
            secondPlace = "2.    ";
            thirdPlace = "2.    ";
        }
        System.out.println("\nTop Schools:\n\n" + firstPlace + firstSchool + ":   " + firstAvg + "\n" + secondPlace + secondSchool + ":   " + secondAvg + "\n" + thirdPlace + thirdSchool + ":    " + thirdAvg);
        System.out.println("\nNew York State Average:   " + total / maxIndx);
    }
}
