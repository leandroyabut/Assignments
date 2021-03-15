package com.leandroyabut.weekendassignment.functional;

import java.util.List;
import java.util.stream.Collectors;

public class RightmostDigit {

    /**
     *
     * @param numbers list of numbers
     * @return new list of numbers with only the right digit
     */
    public List<Integer> getRightMostDigits(List<Integer> numbers) {

        return numbers.stream().map(i -> rightMostDigit().get(i)).collect(Collectors.toList());

    }

    public PerformOperation rightMostDigit() {
        return i -> i % 10;
    }

    public static void main(String[] args) {

        RightmostDigit rmd = new RightmostDigit();

        try(ListInputReader<Integer> listInputReader = new ListInputReader<>("resources/weekendassignment/functional/input1")) {

            List<Integer> rightDigits = rmd.getRightMostDigits(listInputReader.getList());
            System.out.print(listInputReader.getList().toString() + " -> " + rightDigits.toString());

        } catch (Exception exception) {

            exception.printStackTrace();

        }
    }

}
