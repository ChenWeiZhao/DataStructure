package LeetcodeProblemsaboutMapandSet;/// Leetcode 350. Intersection of Two Arrays II
/// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 计算两个数组的交集，包括重复元素
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                //记录频次
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                res.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }

        return ret;
    }
}
