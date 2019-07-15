package CreateOurOwnArray;

public class Array {

    /**
     * 存放int型数据
     */
    private int[] data;

    /**
     * data实际有多少有效元素
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 希望数组开多大的容量
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组的容量
     * @return 数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return 数组中实际有多少元素
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
}
