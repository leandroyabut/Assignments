package com.leandroyabut.weekendassignment.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupSumClumpTest {

    private final GroupSumClump gsc = new GroupSumClump();

    @Test
    public void groupSumClumpTestSuccess() {
        assertTrue(gsc.groupSumClump(0, new int[]{2, 4, 8}, 10));
        assertTrue(gsc.groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14));
        assertTrue(gsc.groupSumClump(0, new int[]{3, 6, 12}, 18));
        assertTrue(gsc.groupSumClump(0, new int[]{1, 4, 4, 6}, 9));
    }

    @Test
    public void groupSumClumpTestFail() {
        assertFalse(gsc.groupSumClump(0, new int[]{2, 4, 4, 8}, 6));
        assertFalse(gsc.groupSumClump(0, new int[]{3, 6, 6, 8}, 9));
        assertFalse(gsc.groupSumClump(0, new int[]{1, 4, 4, 6}, 5));
    }

    @Test
    public void sameIntClumpTest() {
        assertTrue(gsc.groupSumClump(0, new int[]{4, 4, 4}, 12));
        assertTrue(gsc.groupSumClump(0, new int[]{5, 5, 5, 3}, 15));
        assertTrue(gsc.groupSumClump(0, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 1}, 18));
    }

}
