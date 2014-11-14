package com.company;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest extends TestCase {

    public void testTwoSum2() throws Exception {

    }

    @Test
    public void testTwoSum() throws Exception {

        TwoSum obj = new TwoSum();

        int[] input = {1,2,3};
        int[] expected = {0,1};
        assertArrayEquals("Input lenghth is 2",obj.twoSum(input, 3),expected );
    }
}