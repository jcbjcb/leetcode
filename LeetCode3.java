
import java.util.*;

/**
 * Created by jcb on 2019-10-22 14:04
 */
public class LeetCode3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     *
     * 这道题主要用到思路是：滑动窗口
     *
     * 什么是滑动窗口？
     *
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public static int mastStringLen(String s) {
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int j = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
//                System.out.println(s.charAt(i) + "+" + i + "+" + j + "+" + map.get(s.charAt(i)));
                j = map.get(s.charAt(i)) > j ? map.get(s.charAt(i)) : j;
            }
            max = max < i + 1 - j ? i + 1 - j : max;
//            System.out.println(max);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        int max = mastStringLen("aabbccabc");

        System.out.println(max);
    }
}
