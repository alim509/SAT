package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sf = new Scanner(new File("scores.txt"));
        int maxIndx = -1;
        String array [] = new String[2000];
        double average;
        String text[];

        while (sf.hasNext()) {
            maxIndx++;
            array[maxIndx] = sf.nextLine();
            System.out.println(maxIndx);
        }

        sf.close();

        String schoolName;
        int num1 = 0, num2 = 0, num3 = 0;

        for (int i = 1; i < maxIndx; i++) {
            text = array[i].split("\t");
            schoolName = text[1];
            if (text.length > 18) {
                num1 = Integer.parseInt(text[18]);
                num2 = Integer.parseInt(text[19]);
                num3 = Integer.parseInt(text[20]);
                average = (num1 + num2 + num3) / 3;
                System.out.println(schoolName + ": " + average);
            }
        }
    }
}
