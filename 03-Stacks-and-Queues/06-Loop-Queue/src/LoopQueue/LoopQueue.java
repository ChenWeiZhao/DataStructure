package LoopQueue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;   // 有兴趣的同学，在完成这一章后，可以思考一下：
    // LoopQueue中不声明size，如何完成所有的逻辑？
    // 这个问题可能会比大家想象的要难一点点：）

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    // 入队
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            //队列满需要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 出队
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空队列中没有元素，不能执行出队操作");
        }
        E datafront = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return datafront;
    }

    private void resize(int newCappacity) {
        E[] newdata = (E[]) new Object[newCappacity + 1];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[(front + i) % data.length];
        }
        data = newdata;
        front = 0;
        tail = size;
    }



    // 下一小节再做具体实现
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Quene: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue queue = new  LoopQueue<Integer>();
        for (int i = 0 ; i < 100; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if ( i % 4 == 0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
