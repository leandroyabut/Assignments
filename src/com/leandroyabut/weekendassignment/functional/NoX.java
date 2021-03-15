package com.leandroyabut.weekendassignment.functional;

import java.util.List;
import java.util.stream.Collectors;

public class NoX {

    public String removeX(String string) {
        return string.chars().filter(i -> i!='x').collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public List<String> noXList(List<String> strings) {
        return strings.stream().map(this::removeX).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        NoX noX = new NoX();

        try(ListInputReader<String> reader = new ListInputReader<>("resources/weekendassignment/functional/input3")) {

            List<String> strings = reader.getList();
            List<String> noXList = noX.noXList(strings);

            System.out.println(strings.toString() + " -> " + noXList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
