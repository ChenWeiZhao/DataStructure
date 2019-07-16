/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>       类
 *
 * @author chenweizhao
 * 创建日期：2019/7/15 22:18
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package Exercise237;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode cur = this;
        while (cur!=null){
            str.append(cur.val + "->");
            cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }
}
