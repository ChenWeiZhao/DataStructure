package LinkedListProblemsinLeetcode;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/


class Solution {

    public ListNode removeElements(ListNode head, int val) {

        //不使用虚拟头节点
        //删除头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return head;
        }

        //删除链表中间的节点，head一定不是要删除的节点了，后面一个可能是要删除的节点
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            //    删除一个节点后,prev已经的下个节点已经改变了,不要向后挪
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}