package com.leetcode;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SolutionTest {

    private Solution solution = new Solution();

    private int[] nums1 = { 2, 7, 11, 15 };
    private int[] nums2 = { 5, 3, 7, 3, 9 };
    private int[] nums3 = { 1, 2, 2, 3, 4, 5, 5, 7, 7, 7 };

    private int[] num1 = { 2, 4, 3 };
    private int[] num2 = { 5, 6, 4 };
    private int[] num3 = { 7, 0, 8 };
    private int[] num4 = { 1 };
    private int[] num5 = { 9, 9 };
    private int[] num6 = { 0, 0, 1 };
    private ListNode listNode1 = ListNode.toListNode(num1);
    private ListNode listNode2 = ListNode.toListNode(num2);
    private ListNode listNode3 = ListNode.toListNode(num4);
    private ListNode listNode4 = ListNode.toListNode(num5);

    private String s = "PAYPALISHIRING";

    @Test
    @DisplayName("1.Two Sum: normal case")
    void twoSum1() {
        int target = 13;
        int[] answer = { 0, 2 };
        assertArrayEquals(answer, solution.twoSum(nums1, target));
    }

    @Test
    @DisplayName("1.Two Sum: same numbers")
    void twoSum2() {
        int target = 6;
        int[] answer = { 1, 3 };
        assertArrayEquals(answer, solution.twoSum(nums2, target));
    }

    @Test
    @DisplayName("1.Two Sum: no answer, throw exception")
    void twoSumException() {
        int target = 20;
        assertThrows(IllegalArgumentException.class, () -> { solution.twoSum(nums1, target); });
    }

    @Test
    @DisplayName("2. Add Two Numbers: normal case")
    void addTwoNumbers1() {
        ListNode answer = ListNode.toListNode(num3);
        System.out.println("num1:   " + listNode1.toString());
        System.out.println("num2:   " + listNode2.toString());
        assertEquals(answer, solution.addTwoNumbers(listNode1, listNode2));
        System.out.println("answer: " + answer.toString());
    }

    @Test
    @DisplayName("2. Add Two Numbers: special case")
    void addTwoNumbers2() {
        ListNode answer = ListNode.toListNode(num6);
        assertEquals(answer, solution.addTwoNumbers(listNode3, listNode4));
    }

    @Test
    @DisplayName("26.Remove Duplicates from Sorted Array: normal case")
    void removeDuplicates1() {
        int[] noDuplicates = { 1, 2, 3, 4, 5, 7 };
        int answer = 6;
        int length = solution.removeDuplicates(nums3);
        assertEquals(answer, length);
        assertArrayEquals(noDuplicates, Arrays.copyOfRange(nums3, 0, length));
    }

    @Test
    @DisplayName("26.Remove Duplicates from Sorted Array: empty input")
    void removeDuplicates2() {
        int[] empty = {};
        int length = solution.removeDuplicates(empty);
        assertEquals(0, length);
    }

    @Test
    @DisplayName("6. ZigZag Conversion: normal case, with numRows = 3")
    void zigzagConvert1() {
        assertEquals("PAHNAPLSIIGYIR", solution.zigzagConvert(s, 3));
    }

    @Test
    @DisplayName("6. ZigZag Conversion: normal case, with numRows = 4")
    void zigzagConvert2() {
        assertEquals("PINALSIGYAHRPI", solution.zigzagConvert(s, 4));
    }

    @Test
    @DisplayName("6. ZigZag Conversion: special case with numRows = 1")
    void zigzagConvert3() {
        assertEquals(s, solution.zigzagConvert(s, 1));
    }

    @Test
    @DisplayName("6. ZigZag Conversion: special case with numRows = s.length")
    void zigzagConvert4() {
        assertEquals(s, solution.zigzagConvert(s, s.length()));
    }
}