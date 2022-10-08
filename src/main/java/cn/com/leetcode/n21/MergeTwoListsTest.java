package cn.com.leetcode.n21;

/**
 * @Author: wenguoxing
 * @Date: 2022/8/5 7:57
 * @Version 1.0
 */
public class MergeTwoListsTest {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            return l2;
        } else if (l2.next == null) {
            return l1;
        } else if (l1.val < l2.val) {
            //如果l1.val < l2.val，比较l1.next与l2。
            //如果l1.next没有下一节点，返回l2。
            //如果l1.next.val >= l2.val，l2.next=l1.next  相当于 l1.val >= l2.val, l2.next = l1
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            //如果l1.val >= l2.val，比较l2.next与l1。
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void print(ListNode listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode10 = new ListNode(1);
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        listNode11.next = listNode12;
        listNode10.next = listNode11;

        ListNode listNode20 = new ListNode(1);
        ListNode listNode21 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        listNode21.next = listNode22;
        listNode20.next = listNode21;

        ListNode listResult = mergeTwoLists(listNode10, listNode20);

        print(listResult);
    }
}
