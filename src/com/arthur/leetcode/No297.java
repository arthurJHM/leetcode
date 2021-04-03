package com.arthur.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @title: No297
 * @Author ArthurJi
 * @Date: 2021/4/3 18:19
 * @Version 1.0
 */
public class No297 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(LinkedList<String> queue) {
        String cur = queue.poll();
        if("null".equals(cur)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}

/*297. 二叉树的序列化与反序列化
        序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

        提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。



        示例 1：


        输入：root = [1,2,3,null,null,4,5]
        输出：[1,2,3,null,null,4,5]
        示例 2：

        输入：root = []
        输出：[]
        示例 3：

        输入：root = [1]
        输出：[1]
        示例 4：

        输入：root = [1,2]
        输出：[1,2]*/

//思路二：DFS
//        序列化
//        递归的第一步都是特例的处理，因为这是递归的中止条件：如果根节点为空，返回”null“
//        序列化的结果为：根节点值 + "," + 左子节点值(进入递归) + "," + 右子节点值(进入递归)
//        递归就是不断将“根节点”值加到结果中的过程
//        反序列化
//        先将字符串转换成队列（python转换成列表即可）
//        接下来就进入了递归
//        i. 弹出左侧元素，即队列出队
//        ii. 如果元素为“null”，返回null（python返回None）
//        iii. 否则，新建一个值为弹出元素的新节点
//        iv. 其左子节点为队列的下一个元素，进入递归；右子节点为队列的下下个元素，也进入递归
//        v. 递归就是不断将子树的根节点连接到父节点的过程
//        代码
//        javapython3

/*public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if("null".equals(val)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
复杂度分析

        时间复杂度：O(n)
        空间复杂度：O(n)

        作者：edelweisskoko
        链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/297-er-cha-shu-de-xu-lie-hua-yu-fan-xu-l-647c/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
