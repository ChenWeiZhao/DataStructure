package PriorityQueueinJava;/// 347. Top K Frequent Elements
/// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;

public class Solution2 {

    private class Freq {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    /**
     * 比较器，则Freq类不需要事先Comparator接口
     */
    private class FreqComparator implements Comparator<Freq> {
        /**
         * @return -1也可以是任意负数，1也可以是任意正数
         */
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //比较器作为构造函数参数，该比较器定义了谁的优先级大，谁的优先级小
        //可自定义定制比较规则
        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}
