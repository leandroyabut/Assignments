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
     * @param base
     * @param centered
     * @param flipped
     */
    public static void printPattern(int base, boolean centered, boolean flipped, int dotLength, boolean above) {
        ArrayList<String> patternLines = new ArrayList<String>();

        String dotLine = "";
        for(int i = 0; i < dotLength; i++)
            dotLine+=".";

        if(!above) patternLines.add(dotLine);

        for(int i = 1; i <= base; i++) {
            String line = "";
            for (int x = 0; x < i; x++) {
                line += "*";
            }

            if(centered) line = centerString(line, base);

            if(!centered || centered && i%2!=0) patternLines.add(line);
        }

        if(above) patternLines.add(dotLine);
        if(flipped) Collections.reverse(patternLines);

        for(String line : patternLines) {
            System.out.println(line);
        }
        System.out.println();
    }

    /**
     *
     * @param text
     * @param len
     * @return centered string
     */
    public static String centerString(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }
}
