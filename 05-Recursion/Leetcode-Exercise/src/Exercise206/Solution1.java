/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>       类
 *
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
        ListNode newList = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newList;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution1 solution1 = new Solution1();
        ListNode newListNode = solution1.reverseList(listNode);
        System.out.println(newListNode);
    }
}
