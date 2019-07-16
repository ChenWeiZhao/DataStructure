/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>      反转链表
 * ///leetcode 206 reverse linked Node
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author chenweizhao
 * 创建日期：2019/7/15 22:16
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package Exercise206;

public class Solution {
    public ListNode reverseList(ListNode head) {
        //指向当前节点的后驱
        ListNode nextNode;
        //指向当前节点的前驱
        ListNode preNode = null;
        while (head != null) {
            //当前节点的后驱指向前驱的时候，后面的节点和当前节点分开了，需要一个变量来保存当前节点的后驱
            nextNode = head.next;
            //当前节点的后驱指向前驱
            head.next = preNode;
            preNode = head;
            //处理下一个节点
            head = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution solution = new Solution();
        ListNode newListNode = solution.reverseList(listNode);
        System.out.println(newListNode);
    }
}
