package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //given

        int[] nums = new int[20];
        int sum = 0;
        Random generator = new Random();

        for (int i = 0; i < 20; i++) {
            nums[i] = generator.nextInt(100);
            sum += nums[i];
        }

        //when
        double excpected = (double) sum / nums.length;
        double actual = ArrayOperations.getAverage(nums);

        //then
        Assert.assertEquals(excpected, actual, 0);
        Assert.assertEquals(20, nums.length);
    }

}
