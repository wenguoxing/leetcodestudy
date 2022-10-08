package cn.com.leetcode.n21;

/**
 * @Author: wenguoxing
 * @Date: 2022/8/5 8:09
 * @Version 1.0
 */
public class ListNode {
    //数据 ：节点数据
    int val;
    //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        //把接收的参数赋值给当前类的val变量
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
