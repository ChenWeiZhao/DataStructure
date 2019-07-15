package LinkedListBasics;

public class LinkedList<E> {

    /**
     * 私有内部类，用户不需要了解链表内部的实现，
     * 用户只需要知道链表是线性结构，对用户屏蔽底层的实现细节
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

}
