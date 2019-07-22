package ExtractandSiftDowninHeap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

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

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * 时间复杂度 O(log n)
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    /**
     * 取出整个堆中最大的元素
     * 时间复杂度 O(log n)
     */
    public E extractMax() {
        //暂存堆中最大元素
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    //下层根节点
    private void siftDown(int k) {
        //若K的左孩子越界，说明k节点一个孩子都没有
        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);//j是k的左孩子，j+1是右孩子
            if (j + 1 < data.getSize() && (data.get(j + 1).compareTo(data.get(j)) > 0)) {
                //当右孩子大于左孩子时
                j++;//右孩子
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            // 使得k和最大值做比较
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                //当k大于左右孩子时，下沉过程结束
                break;
            }
            //否则交换两个元素的位置
            data.swap(k, j);
            //进行下一轮循环的条件
            k = j;
        }
    }
}
