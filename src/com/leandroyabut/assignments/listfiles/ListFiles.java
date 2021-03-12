package com.leandroyabut.assignments.listfiles;

import com.leandroyabut.assignments.singleton.SingletonClass;

import java.util.Scanner;

public class ListFiles {

    public static void main(String[] args) {

        System.out.print("Please enter a directory to list: ");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        FileListHandler fileListHandler = new FileListHandler(path);
        fileListHandler.listFiles();

        scanner.close();

    }

}
