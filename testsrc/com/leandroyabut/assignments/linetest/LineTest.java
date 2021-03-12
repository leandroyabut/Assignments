package com.leandroyabut.assignments.linetest;

import com.leandroyabut.assignments.unittesting.Line;
import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    @Test
    public void getSlopeTest() {
        Line line1 = new Line(0, 0, 3, 9);
        double expectedSlope = 3;

        Assert.assertEquals("Testing slopes...", expectedSlope, line1.getSlope(), .0001);
    }

    @Test
    public void getDistanceTest() {
        Line line1 = new Line(10, 5, 30, 15);
        double expectedDistance = 22.36068;

        Assert.assertEquals("Testing distance...", expectedDistance, line1.getDistance(), .0001);
    }

    @Test
    public void parallelToTest() {
        Line line1 = new Line(0, 0, 3, 9);
        Line line2 = new Line(2, 2, 5, 11);

        Assert.assertTrue(line1.parallelTo(line2));
    }

}
