package com.arthur.bishi.meituan0808;

import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.soap.Node;
import java.security.ProtectionDomain;
import java.util.*;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/8 11:39
 * @modifiedBy：
 * @version: 1.0
 */
public class No5 {
    static HashSet<Integer> mm = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new TreeNode(i));
        }
        for (int i = 1; i <= n; i++) {
            TreeNode treeNode = map.get(i);
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l != 0) {
                treeNode.setLeft(map.get(l));
            }
            if (r != 0) {
                treeNode.setRight(map.get(r));
            }
        }
        for (int i = 0; i < m; i++) {
            mirr(map.get(scanner.nextInt()));
        }
        inorder(map.get(k));
    }
    private static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
    public static void mirr(TreeNode root) {
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
