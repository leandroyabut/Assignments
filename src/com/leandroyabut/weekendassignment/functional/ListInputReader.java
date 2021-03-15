package com.leandroyabut.weekendassignment.functional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListInputReader<T> implements AutoCloseable {

    private InputStream stream;
    private final List<T> list;

    /**
     * Reads a file of inputs into a list of type <i>T</i>.
     * @param path Path to file to read input from.
     */
    public ListInputReader(final String path) {
        list = new ArrayList<>();
        try {
            stream = new FileInputStream(path);
        } catch (FileNotFoundException exception) {
            System.out.println("File does not exist...");
            exception.printStackTrace();
        }

        readIntoList();
    }

    public List<T> getList() {
        return list;
    }

    /**
     *
     * Reads object of type T into a list of type T.
     * T can only be a String or Integer.
     * The first element of a list input must be absolutely of
     * type T.
     */
    private void readIntoList() {
        try(Scanner scanner = new Scanner(stream)) {
            while(scanner.hasNext()) {
                if(list.size() == 0)
                    if (scanner.hasNextInt()) {
                        list.add((T) new Integer(scanner.nextInt()));
                    } else {
                        list.add((T) scanner.nextLine());
                    }
                else {
                    if(list.get(0) instanceof Integer) {
                        list.add((T) new Integer(scanner.nextInt()));
                    } else {
                        list.add((T) scanner.nextLine());
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Make sure the first element matches the generic type...");
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if(stream!=null) stream.close();
    }
}
