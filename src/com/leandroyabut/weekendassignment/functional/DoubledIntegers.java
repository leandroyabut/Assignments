package com.leandroyabut.weekendassignment.functional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DoubledIntegers {

    /**
     *
     * @param integers list of integers to double
     * @return list with the integers multiplied by 2
     */
    public List<Integer> getDoubledList(List<Integer> integers) {
        return integers.stream().map(doubled()::get).collect(Collectors.toList());
    }

    public PerformOperation doubled() {
        return i -> i * 2;
    }

    public static void main(String[] args) {

        DoubledIntegers doubledIntegers = new DoubledIntegers();

        try(ListInputReader<Integer> reader = new ListInputReader<>("resources/weekendassignment/functional/input2")) {

            List<Integer> integers = reader.getList();
            List<Integer> doubled = doubledIntegers.getDoubledList(integers);

            System.out.println(integers.toString() + " -> " + doubled.toString());

        } catch (IOException e){
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}