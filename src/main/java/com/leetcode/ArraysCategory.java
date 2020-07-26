package com.leetcode;

import java.util.Arrays;

public class ArraysCategory {

    /**
     * 散列表
     * ArrayList，可变长数组
     * StringBuilder
     */


    /**
     * 1. 判定字符是否唯一。实现一个算法，确定一个字符串的所有字符是否全都不同。假使不允许使用额外的数据结构，又该如何处理？
     * 提示:
     *   #44 - 用散列表试试
     *   #117 - 位向量有用吗？
     *   #132 - 能用O(NlogN)的时间复杂度解决它吗？这样的解法会是什么样呢？
     */
    public boolean isUniqueChar1(String str) {
        /**
         * 假设所有字符均为ASCII字符，如果是Unicode需要扩大存储空间
         * 利用字符集的散列表数组来表示某个字符出现与否
         */
        if (str.length() > 128) return false;

        boolean[] charset = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
            if (charset[charValue])
                return false;
            charset[charValue] = true;
        }

        return true;
    }

    public boolean isUniqueChar2(String str) {
        /**
         * 假设所有字符均为ASCII字符，如果是Unicode需要扩大存储空间
         * 利用字符集的散列表来表示某个字符出现与否，使用位向量而不是数组
         */
        if (str.length() > 128) return false;

        int[] charset = new int[4];
        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
            int index = (charValue - 1) / 32;
            int bit = (charValue - 1) % 32;
            if ((charset[index] & (1 << (31 - bit))) > 1)
                return false;
            charset[index] |= 1 << (31 - bit);
        }

        return true;
    }

    public boolean isUniqueChar3(char[] str) {
        /**
         * 假设所有字符均为ASCII字符，如果是Unicode需要重新考虑
         * 不使用额外空间，但可以修改原字符串，所以使用char[]类型
         */
        if (str.length > 128) return false;

        Arrays.sort(str); // quick-sort in-place
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i-1])
                return false;
        }

        return true;
    }


    /**
     * 2. 判定是否互为字符重排。给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * 提示: #1，#84，#122，#131
     */

    /**
     * 3. URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * 提示: #53，#118
     */

    /**
     * 4. 回文排列。给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。回文串是指正反两个方向都一样的单词或短语。
     *    排列是指字母的重新排列。回文串不一定是字典当中的单词。
     * 提示: #106，#121，#134，#136
     */

    /**
     * 5. 一次编辑。字符串有三种编辑操作：插入一个字符、删除一个字符或者替换一个字符。给定两个字符串，
     *    编写一个函数判定它们是否只需要一次（或者零次）编辑。
     * 提示: #23，#97，#130
     */

    /**
     * 6. 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     *    若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母(a至z)。
     * 提示: #92，#110
     */

    /**
     * 7. 旋转矩阵。给定一幅由N×N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
     *    不占用额外内存空间能否做到？
     * 提示: #51，#100
     */

    /**
     * 8. 零矩阵。编写一种算法，若M×N矩阵中某个元素为0，则将其所在的行与列清零。
     * 提示: #17，#74，#102
     */

    /**
     * 9. 字符串轮转。假定有一种isSubstring方法，可检查一个单词是否为其他字符串的子串。给定两个字符串s1和s2，
     *    请编写代码检查s2是否为s1旋转而成，要求只能调用一次isSubstring(比如，waterbottle是erbottlewat旋转后的字符串)。
     * 提示: #34，#88，#104
     */
}
