/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>      删除链表中的节点 类
 * ///leetcode 237 remove linked Node
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author chenweizhao
 * 创建日期：2019/7/15 22:16
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package Exercise237;

public class Solution {
    public void deleteNode(ListNode node) {
        //用下个节点的值替换当前节点的值就表示删除了当前节点了
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution solution = new Solution();
        solution.deleteNode(listNode);
        System.out.println(listNode);
    }
}
