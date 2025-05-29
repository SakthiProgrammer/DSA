package BinaryTree;

import java.util.List;
import Utility.MethodCall;

public class BinaryTreeCall implements MethodCall {

    @Override
    public void call() {
        BinaryTree binaryTree = new BinaryTree();

        /* ============================================== P: 35 */
        // 1. Average of Levels in Binary Tree
        /* ============================================== */
        // Tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        List<Double> avgLevels = binaryTree.averageOfLevels(root1);
        System.out.println("Average of Levels: " + avgLevels); // [3.0, 14.5, 11.0]

        /* ============================================== P: 36 */
        // 2. Minimum Depth of Binary Tree
        /* ============================================== */
        // Tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        int minDepth = binaryTree.minDepth(root2);
        System.out.println("Minimum Depth: " + minDepth); // 2

        // Tree:
        // 2
        // \
        // 3
        // \
        // 4
        // \
        // 5
        // \
        // 6
        TreeNode root3 = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.right.right = new TreeNode(4);
        root3.right.right.right = new TreeNode(5);
        root3.right.right.right.right = new TreeNode(6);
        minDepth = binaryTree.minDepth(root3);
        System.out.println("Minimum Depth: " + minDepth); // 5

        /* ============================================== P: 36 */
        // 3. Maximum Depth of Binary Tree
        /* ============================================== */
        // Tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root4 = new TreeNode(3);
        root4.left = new TreeNode(9);
        root4.right = new TreeNode(20);
        root4.right.left = new TreeNode(15);
        root4.right.right = new TreeNode(7);
        int maxDepth = binaryTree.maxDepth(root4);
        System.out.println("Maximum Depth: " + maxDepth); // 3

        // Tree:
        // 1
        // \
        // 2
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        maxDepth = binaryTree.maxDepth(root5);
        System.out.println("Maximum Depth: " + maxDepth); // 2

        /* ============================================== */
        // 4. Max Value in Binary Tree (Custom Utility)
        /* ============================================== */

        // Tree:
        // 5
        // / \
        // 1 9
        root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(9);
        System.out.println("Min Value: " + binaryTree.minValue(root1)); // Output: 1
        System.out.println("Max Value: " + binaryTree.maxValue(root1)); // Output: 9

        // Tree:
        // -10
        // / \
        // -20 -3
        // /
        // -1
        root2 = new TreeNode(-10);
        root2.left = new TreeNode(-20);
        root2.right = new TreeNode(-3);
        root2.right.left = new TreeNode(-1);
        System.out.println("Min Value: " + binaryTree.minValue(root2)); // Output: -20
        System.out.println("Max Value: " + binaryTree.maxValue(root2)); // Output: -1

        // Tree:
        // 7
        // / \
        // 4 8
        // / \
        // 6 13
        root3 = new TreeNode(7);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(8);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(13);
        System.out.println("Min Value: " + binaryTree.minValue(root3)); // Output: 4
        System.out.println("Max Value: " + binaryTree.maxValue(root3)); // Output: 13
    }
}
