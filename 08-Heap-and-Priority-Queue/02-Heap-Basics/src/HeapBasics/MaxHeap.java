package HeapBasics;

/**
 * 根节点为1的情况
 * 父节点的索引是子节点索引的1/2
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 根节点为1的情况
     * 父节点的索引是子节点索引的1/2
     * 右节点索引= 当前节点索引*2 + 1
     */
    public MaxHeap() {
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * 根节点为0的情况
     * 父节点的索引是子节点索引的(index-1)/2
     *
     * @return 父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            //根节点没有父节点
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * 左节点索引 = 当前节点索引*2 + 1
     *
     * @return 左孩子的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * 右节点索引= 当前节点索引*2 + 2
     *
     * @return 右孩子的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
