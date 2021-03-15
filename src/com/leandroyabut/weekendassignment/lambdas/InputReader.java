package com.leandroyabut.weekendassignment.lambdas;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader implements AutoCloseable{

    private int caseCount;
    private int[][] cases;
    private String streamPath;
    private InputStream inputStream;

    public InputReader(String streamPath) {
        this.streamPath = streamPath;
        try {
            inputStream = new FileInputStream(streamPath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }
        setCases();
    }

    private void setCases() {
        if(inputStream != null)
            try(Scanner scanner = new Scanner(inputStream)) {

                caseCount = scanner.nextInt();
                cases = new int[caseCount][];

                for(int i = 0; i < caseCount; i++) {
                    cases[i] = new int[2];

                    for(int j = 0; j < 2; j++)
                        if(scanner.hasNextInt()) {
                            cases[i][j] = scanner.nextInt();
                        }
                }

            } catch (InputMismatchException e) {
                System.out.println("Input is a not a number...");
            } catch (NoSuchElementException e) {
                System.out.println("No such element...");
            } catch (IllegalStateException e) {
                System.out.println("Cannot access stream...");
            }
        else {
            caseCount = 0;
            cases = null;
        }
    }

    public int[][] getCases() {
        return cases;
    }

    @Override
    public void close() throws Exception {
        if(inputStream!=null)inputStream.close();
    }
}
