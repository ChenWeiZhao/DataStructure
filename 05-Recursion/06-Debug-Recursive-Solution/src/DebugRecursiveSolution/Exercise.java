/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>       类
 *
 * @author chenweizhao
 * 创建日期：2019/7/15 21:41
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package DebugRecursiveSolution;

public class Exercise {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode resNode = removeElements(head.next, val);
        if (head.val == val) {
            return resNode;
        } else {
            head.next = resNode;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        Exercise exercise = new Exercise();
        ListNode listNode = new ListNode(arr);
        ListNode resNode = exercise.removeElements(listNode, 2);
        System.out.println(resNode);
    }

}
