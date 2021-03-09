package com.leandroyabut.assignments.patterns;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Day 1 Assignment
 * Print out patterns...
 */

public class Patterns {

    public static void main(String[] args) {
        printPattern(4, false, false, 9, false);
        printPattern(4, false, true, 10, true);
        printPattern(7, true, false, 11, false);
        printPattern(7, true, true, 12, true);
    }

    /**
     *
     * @param base the length of the base
     * @param centered if the pattern is centered
     * @param flipped if the patter is flipped
     * @param dotLength how many dots to print
     * @param above if the dots should be printed above the pattern
     */
    public static void printPattern(int base, boolean centered, boolean flipped, int dotLength, boolean above) {
        ArrayList<String> patternLines = new ArrayList<>();

        StringBuilder dotLine = new StringBuilder();
        for(int i = 0; i < dotLength; i++)
            dotLine.append(".");
        for(int i = 1; i <= base; i++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < i; x++) {
                line.append("*");
            }

            if(centered) line = new StringBuilder(centerString(line.toString(), base));

            if(!centered || i % 2 != 0) patternLines.add(line.toString());
        }

        if(flipped) Collections.reverse(patternLines);

        if(above) System.out.println(dotLine.toString());
        for(String line : patternLines) {
            System.out.println(line);
        }
        if(!above) System.out.println(dotLine.toString());
        System.out.println();
    }

    /**
     *
     * @param text string to be centered
     * @param len buffer length
     * @return centered string
     */
    public static String centerString(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (float)out.length()/(float)2;
        float start = mid - (float)(len / 2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }
}
