package TimeComplexityofSet;

import java.util.ArrayList;

public class Main {

    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";
        //查找是O(h)级别，二分搜索树高度h； 总节点数 n = 2^h-1，时间复杂度 O（log2 n）
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        //在链表中，查找元素是否存在，查是O（n）级别
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

    }
}
