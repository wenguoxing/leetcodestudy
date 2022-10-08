package cn.com.leetcode.n20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: wenguoxing
 * @Date: 2022/7/26 16:19
 * @Version 1.0
 */
public class BracketValidTest {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                //peek 查看栈顶部的对象，但不从栈中移除它
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                //移除栈顶部的对象，并作为此函数的值返回该对象
                stack.pop();
            } else {
                //把项压入栈顶部
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
