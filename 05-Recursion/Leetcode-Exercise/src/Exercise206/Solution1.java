/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>       类
 *  https://leetcode-cn.com/problems/reverse-linked-list/
 * @author chenweizhao
 * 创建日期：2019/7/16 20:29
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package Exercise206;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归反转链表
        ListNode p = reverseList(head.next);
        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution1 solution1 = new Solution1();
        ListNode newListNode = solution1.reverseList(listNode);
        System.out.println(newListNode);
    }
}
