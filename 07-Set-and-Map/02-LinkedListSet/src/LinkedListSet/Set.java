package LinkedListSet;

public interface Set<E> {

    /**
     * 不能添加重复元素
     * 典型应用：客户统计、词汇量统计
     */
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
