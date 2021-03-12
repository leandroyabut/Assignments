package com.leandroyabut.assignments.listfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class to handle listing files in the console
 * in an organized format.
 *
 * @author Leandro Yabut
 */

public class FileListHandler {

    private String path;
    private int level;

    /**
     *
     * @param path directory to list files from
     */
    public FileListHandler(String path) {
        this.path = path;
        this.level = 0;
    }

    public String getPath() {
        return path;
    }

    public void listFiles() {
        File dir = new File(getPath());
        if(dir.exists() && dir.isDirectory())
            listFiles(dir);
        else System.out.println("Directory does not exist...");
    }

    /**
     *
     * @param pathDir directory to print files from
     */
    public void listFiles(File pathDir) {
        File[] fileList = pathDir.listFiles();
        List<File> dirs = new ArrayList<>();
        int currentLevel = level;

        assert fileList != null;

        for(File file : fileList) {
            if(file.isDirectory()) {
                dirs.add(file);
            } else {
                System.out.println(tabs(level) + file.getName());
            }
        }

        for(File dir : dirs) {
            System.out.println(tabs(level) + dir.getName() + " >");
            level++;
            listFiles(dir);
            level = currentLevel;
        }
    }

    /**
     *
     * @param tabLength how many tabs to create
     * @return string with n number of tabs
     */
    private String tabs(int tabLength) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tabLength; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
