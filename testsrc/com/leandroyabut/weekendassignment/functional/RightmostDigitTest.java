package com.leandroyabut.weekendassignment.functional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RightmostDigitTest {

    private final RightmostDigit rightmostDigit = new RightmostDigit();

    @Test
    public void rightMostDigitTest() {

        int[] numbers = new int[]{1, 0, 100, 55, 67, 123, 548, 1324};
        int[] expectedDigits = new int[]{1, 0, 0, 5, 7, 3, 8, 4};

        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int expectedDigit = expectedDigits[i];
            int rightDigit = check(rightmostDigit.rightMostDigit(), number);
            assertEquals(expectedDigit, rightDigit);
        }
    }

    @Test
    public void emptyRightMostDigitTest() {

        int[] numbers = new int[5];
        int[] expectedDigits = new int[5];

        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int expectedDigit = expectedDigits[i];
            int rightDigit = check(rightmostDigit.rightMostDigit(), number);
            assertEquals(expectedDigit, rightDigit);
        }
    }

    @Test
    public void getRightMostDigitsTest() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(10);
        integers.add(201);
        integers.add(52);
        integers.add(3);

        List<Integer> output = rightmostDigit.getRightMostDigits(integers);

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertEquals(expected, output);
    }

    private int check(PerformOperation operation, int number) {
        return operation.get(number);
    }

}
