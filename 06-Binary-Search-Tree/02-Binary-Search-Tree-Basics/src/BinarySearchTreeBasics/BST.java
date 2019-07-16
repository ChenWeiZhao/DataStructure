package BinarySearchTreeBasics;

/**
 * 二叉树
 *      具有唯一根节点
 *      每个节点最多有2个孩子，每个节点最多有一个父亲节点
 *      具有天然递归结构：每个节点的左右子树也是二叉树，左右孩子也是根节点
 * 二叉搜索树（binary search tree）
 *      ——>存储的元素必须有可比较性
 *      每个节点的值，大于其左子树所有节点的值，小于其右子树所有节点的值
 *      左右子树也是二分搜索树，大大加快了查询速度
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    /**
     * 存储了多少个元素
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
