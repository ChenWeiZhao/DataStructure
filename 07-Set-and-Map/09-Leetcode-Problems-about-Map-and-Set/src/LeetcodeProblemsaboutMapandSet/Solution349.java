package LeetcodeProblemsaboutMapandSet;/// Leetcode 349. Intersection of Two Arrays
/// https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 计算两个数组的交集，不包括重复元素
 */
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        //存储nums1的数组
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {//如果nums1中包含nums2
                //最终结果增加num
                list.add(num);
                //并从nums1中移除
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
