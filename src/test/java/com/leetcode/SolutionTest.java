package com.leetcode;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    @DisplayName("1.Two Sum: normal case")
    void twoSum1() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 13;
        int[] answer = { 0, 2 };
        assertArrayEquals(answer, solution.twoSum(nums, target));
    }

    @Test
    @DisplayName("1.Two Sum: same numbers")
    void twoSum2() {
        int[] nums = { 5, 3, 7, 3, 9 };
        int target = 6;
        int[] answer = { 1, 3 };
        assertArrayEquals(answer, solution.twoSum(nums, target));
    }

    @Test
    @DisplayName("1.Two Sum: no answer, throw exception")
    void twoSumException() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 20;
        assertThrows(IllegalArgumentException.class, () -> { solution.twoSum(nums, target); });
    }

    @Test
    @DisplayName("2.Add Two Numbers: normal case")
    void addTwoNumbers1() {
        int[] num1 = { 2, 4, 3 };
        int[] num2 = { 5, 6, 4 };
        int[] num3 = { 7, 0, 8 };
        ListNode listNode1 = ListNode.toListNode(num1);
        ListNode listNode2 = ListNode.toListNode(num2);
        ListNode answer = ListNode.toListNode(num3);
        assertEquals(answer, solution.addTwoNumbers(listNode1, listNode2));
    }

    @Test
    @DisplayName("2.Add Two Numbers: special case")
    void addTwoNumbers2() {
        int[] num1 = { 1 };
        int[] num2 = { 9, 9 };
        int[] num3 = { 0, 0, 1 };
        ListNode listNode1 = ListNode.toListNode(num1);
        ListNode listNode2 = ListNode.toListNode(num2);
        ListNode answer = ListNode.toListNode(num3);
        assertEquals(answer, solution.addTwoNumbers(listNode1, listNode2));
    }

    @Test
    @DisplayName("3.Longest Substring Without Repeating Characters: normal case")
    void lengthOfLongestSubstring1() {
        String s = "abcabcbb";
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    @Test
    @DisplayName("3.Longest Substring Without Repeating Characters: all the same chars")
    void lengthOfLongestSubstring2() {
        String s = "bbbbb";
        assertEquals(1, solution.lengthOfLongestSubstring(s));
    }

    @Test
    @DisplayName("3.Longest Substring Without Repeating Characters: substring check")
    void lengthOfLongestSubstring3() {
        String s = "pwwkew";
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    @Test
    @DisplayName("6.ZigZag Conversion: normal case, with numRows = 3")
    void zigzagConvert1() {
        String s = "PAYPALISHIRING";
        assertEquals("PAHNAPLSIIGYIR", solution.zigzagConvert(s, 3));
    }

    @Test
    @DisplayName("6.ZigZag Conversion: normal case, with numRows = 4")
    void zigzagConvert2() {
        String s = "PAYPALISHIRING";
        assertEquals("PINALSIGYAHRPI", solution.zigzagConvert(s, 4));
    }

    @Test
    @DisplayName("6.ZigZag Conversion: special case with numRows = 1")
    void zigzagConvert3() {
        String s = "PAYPALISHIRING";
        assertEquals(s, solution.zigzagConvert(s, 1));
    }

    @Test
    @DisplayName("6.ZigZag Conversion: special case with numRows = s.length")
    void zigzagConvert4() {
        String s = "PAYPALISHIRING";
        assertEquals(s, solution.zigzagConvert(s, s.length()));
    }

    @Test
    @DisplayName("26.Remove Duplicates from Sorted Array: normal case")
    void removeDuplicates1() {
        int[] nums = { 1, 2, 2, 3, 4, 5, 5, 7, 7, 7 };
        int[] noDuplicates = { 1, 2, 3, 4, 5, 7 };
        int answer = 6;
        int length = solution.removeDuplicates(nums);
        assertEquals(answer, length);
        assertArrayEquals(noDuplicates, Arrays.copyOfRange(nums, 0, length));
    }

    @Test
    @DisplayName("26.Remove Duplicates from Sorted Array: empty input")
    void removeDuplicates2() {
        int[] empty = {};
        int length = solution.removeDuplicates(empty);
        assertEquals(0, length);
    }
}