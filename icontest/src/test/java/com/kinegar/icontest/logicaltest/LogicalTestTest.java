package com.kinegar.icontest.logicaltest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicalTestTest {

    @ParameterizedTest(name = "value={0},expected{1}")
    @Order(1)
    @CsvFileSource(resources = "/reversewords.csv")
    void reverseWordsTest(String  value, String expected) {
        assertEquals(expected, LogicalTest.reverseWords(value));
    }

    @Order(2)
    @ParameterizedTest(name = "value={0},expected{1}")
    @CsvFileSource(resources = "/fizzbuzz100.csv")
    void fizzBuzzTest(int value, String expected) {
        assertEquals(expected,LogicalTest.fizzBuzz(value));
    }

    @Test
    @Order(3)
    void fibonacciSequenceTest() {
        List<Integer> expectedList = Arrays.asList(0,1,1,2,3,5,8,13,21);
        List<Integer> actualList = LogicalTest.fibonacciSequence(0,1,9);
        assertIterableEquals(expectedList,actualList);
    }

    @Test
    @Order(4)
    void highestStockProfitTest() {
        int[] stock1 = new int[]{7,8,3,10,8};
        int expected1 = 7;
        int[] stock2 = new int[]{5,12,11,12,10};
        int expected2 = 7;
        int[] stock3 = new int[]{7,18,27,10,29};
        int expected3 = 22;
        int[] stock4 = new int[]{20,17,15,14,10};
        int expected4 = 0;
        assertEquals(expected1,LogicalTest.highestStockProfit(stock1));
        assertEquals(expected2,LogicalTest.highestStockProfit(stock2));
        assertEquals(expected3,LogicalTest.highestStockProfit(stock3));
        assertEquals(expected4,LogicalTest.highestStockProfit(stock4));
    }

    @Test
    @Order(5)
    void numberOfIntegerTest() {
        char[] list1 = new char[]{'b','7','h','6','h','k','i','5','g','7','8'};
        int expected1 = 5;
        char[] list2 = new char[]{'7','b','8','5','6','9','n','f','y','6','9'};
        int expected2 = 7;
        char[] list3 = new char[]{'u','h','b','n','7','6','5','1','g','7','9'};
        int expected3 = 6;
        assertEquals(expected1,LogicalTest.numberOfInteger(list1));
        assertEquals(expected2,LogicalTest.numberOfInteger(list2));
        assertEquals(expected3,LogicalTest.numberOfInteger(list3));

    }
}