package RecursionBasics;

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        //求解基本问题，基本问题极其简单
        if (l == arr.length)
            return 0;
        //把原问题转换成更小的问题：
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
