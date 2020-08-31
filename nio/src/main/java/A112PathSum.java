import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName PACKAGE_NAME
 * Company: com.yin
 * date 2020/7/8
 */
public class A112PathSum {
    /* -----------------------------------
     *  WARNING:
     * -----------------------------------
     *  Your code may fail to compile
     *  because it contains public class
     *  declarations.
     *  To fix this, please remove the
     *  "public" keyword from your class
     *  declarations.
     */

    private int sumTree = 0;

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            boolean ret = new A112PathSum().hasPathSum(root, sum);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        return cur(root, sum);
    }

    /**
     * [5,4,8,11,null,13,4,7,2,null,null,null,1]
     * 22
     *
     * [1,2]
     * 1
     * @param root 树
     * @param sum 匹配和
     * @return 有还是没有
     */
    private boolean cur(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sumTree += root.val;
        if (root.left != null) {
            if(cur(root.left, sum)) {
                return true;
            }
        }
        if (root.right != null) {
            if(cur(root.right, sum)) {
                return true;
            }
        }
        if (root.left == null && root.right == null && sum == sumTree) {
            return true;
        }
        sumTree -= root.val;
        return false;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
