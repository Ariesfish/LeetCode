package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode toListNode(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int n : nums) {
            current.next = new ListNode(n);
            current = current.next;
        }

        return dummy.next;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ListNode) {
            ListNode num = (ListNode) obj;
            ListNode cur = this;
            while (cur != null) {
                if (num != null) {
                    if (cur.val != num.val)
                        break;
                    cur = cur.next;
                    num = num.next;
                } else {
                    break;
                }
            }

            if (cur == null && num == null) {
                equal = true;
            }
        }

        return equal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;

        sb.append("(");
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        sb.append(")");

        return sb.toString();
    }
}

public class Solution {

    /**
     * 1. Two Sum
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     *   Given nums = [2, 7, 11, 15], target = 9,
     *
     *   Because nums[0] + nums[1] = 2 + 7 = 9,
     *   return [0, 1].
     *
     * @param nums Array of integers
     * @param target Target sum
     * @return Index pair
     * @throws IllegalArgumentException On no solution
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numPool = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // can not use the same element twice
            if (numPool.containsKey(complement) && numPool.get(complement) != i) {
                return new int[] { numPool.get(complement), i };
            }
            numPool.put(nums[i], i);
        }
        // if there is no solution
        throw new IllegalArgumentException("There is no solution for two sum question.");
    }


    /**
     * 2. Add Two Numbers
     *
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *   Output: 7 -> 0 -> 8
     *   Explanation: 342 + 465 = 807.
     *
     * @param l1 one number
     * @param l2 another number
     * @return ListNode sum of the two numbers
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        ListNode x = l1, y = l2;
        int carry = 0;

        while (x != null || y != null) {
            int val1 = (x != null) ? x.val : 0;
            int val2 = (y != null) ? y.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            iter.next = new ListNode(sum % 10);
            iter = iter.next;

            if (x != null) x = x.next;
            if (y != null) y = y.next;
        }

        if (carry > 0) {
            iter.next = new ListNode(carry);
        }

        return dummy.next;
    }

    /**
     * 6. ZigZag Conversion
     *
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *      string convert(string s, int numRows);
     *
     * Example 1:
     *
     *  Input: s = "PAYPALISHIRING", numRows = 3
     *  Output: "PAHNAPLSIIGYIR"
     *
     * Example 2:
     *
     *  Input: s = "PAYPALISHIRING", numRows = 4
     *  Output: "PINALSIGYAHRPI"
     *
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param s Given string
     * @param numRows row to zigzag
     * @return new zigzag string
     */
    public String zigzagConvert (String s, int numRows) {
        // special cases
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder zigzag = new StringBuilder();
        ArrayList<StringBuilder> zigzagBuilder = new ArrayList<>(numRows);
        for (int n = 0; n < numRows; n++) {
            zigzagBuilder.add(n, new StringBuilder());
        }
        int toward = 1;

        // construct zigzag index of new string
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j == 0) {
                toward = 1;
            }
            if (j == (numRows - 1)) {
                toward = -1;
            }

            zigzagBuilder.get(j).append(s.charAt(i));
            j += toward; // j will be between 0 ~ numRows-1, like 0123210123210 when numRows is 4
        }

        for (int n = 0; n < numRows; n++) {
            zigzag.append(zigzagBuilder.get(n).toString());
        }

        return zigzag.toString();
    }


    /**
     * 26. Remove Duplicates from Sorted Array
     *
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Example 1:
     *
     * Given nums = [1,1,2],
     *
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     *
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     *
     * Given nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
     *
     * It doesn't matter what values are set beyond the returned length.
     * Clarification:
     *
     * Confused why the returned value is an integer but your answer is an array?
     *
     * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
     *
     * Internally you can think of this:
     *
     * nums is passed in by reference. (i.e., without making a copy)
     * int len = removeDuplicates(nums);
     *
     * any modification to nums in your function would be known by the caller.
     * using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * @param nums A sorted array
     * @return New length of the array
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[current]) {
                current += 1;
                nums[current] = nums[i];
            }
        }

        return current + 1; // array's new length
    }
}
