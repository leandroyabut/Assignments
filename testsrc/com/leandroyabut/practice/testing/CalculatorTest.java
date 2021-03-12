package com.leandroyabut.practice.testing;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        Assert.assertEquals(5, calculator.add(3, 2));
    }

}
