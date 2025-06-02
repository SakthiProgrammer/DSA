package BinaryTree;

import java.util.List;
import Utility.MethodCall;
import Utility.TreeNode;

public class BinaryTreeCall implements MethodCall {

        @Override
        public void call() {
                BinaryTree binaryTree = new BinaryTree();

                /* ============================================== P: 36 */
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

                /* ============================================== P: 37 */
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

                /* ============================================== P: 38 */
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

                /*
                 * ========================================= P: 39(Max Value) - 40(MinValue)
                 * // 4, 5. Min\Max Value in Binary Tree (Custom Utility)
                 * /* ==============================================
                 */

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

                /*
                 * ================================================= P: 41
                 * // 6. Level Order Traversal
                 * ==============================================
                 */

                // Tree:
                // 3
                // / \
                // 9 20
                // / \
                // 15 7
                root1 = new TreeNode(3);
                root1.left = new TreeNode(9);
                root1.right = new TreeNode(20);
                root1.right.left = new TreeNode(15);
                root1.right.right = new TreeNode(7);

                System.out.println("Level Order Traversal: " + binaryTree.levelOrder(root1));// [[3], [9, 20], [15, 7]]

                // Tree:
                // 1
                root2 = new TreeNode(1);

                System.out.println("Level Order Traversal: " + binaryTree.levelOrder(root2)); // [[1]]

                // Empty tree
                root3 = null;

                System.out.println("Level Order Traversal: " + binaryTree.levelOrder(root3));// []

                /*
                 * ================================================= P: 42
                 * // 7. Path Sum
                 * ==============================================
                 */

                // Tree:
                // 5
                // / \
                // 4 8
                // / / \
                // 11 13 4
                // / \ \
                // 7 2 1

                root1 = new TreeNode(5);
                root1.left = new TreeNode(4);
                root1.right = new TreeNode(8);
                root1.left.left = new TreeNode(11);
                root1.left.left.left = new TreeNode(7);
                root1.left.left.right = new TreeNode(2);
                root1.right.left = new TreeNode(13);
                root1.right.right = new TreeNode(4);
                root1.right.right.right = new TreeNode(1);

                System.out.println("Path Sum: " + binaryTree.hasPathSum(root1, 22)); // Output: true

                // Tree:
                // 1
                // / \
                // 2 3

                root2 = new TreeNode(1);
                root2.left = new TreeNode(2);
                root2.right = new TreeNode(3);

                System.out.println("Path Sum: " + binaryTree.hasPathSum(root2, 5)); // Output: false

                // Tree: Empty
                root3 = null;
                System.out.println("Path Sum: " + binaryTree.hasPathSum(root3, 0)); // Output: false

                /*
                 * ================================================= P: 43
                 * // 8. Same Tree
                 * ==============================================
                 */

                // Tree p:
                // 1
                // / \
                // 2 3

                // Tree q:
                // 1
                // / \
                // 2 3

                TreeNode p1 = new TreeNode(1);
                p1.left = new TreeNode(2);
                p1.right = new TreeNode(3);

                TreeNode q1 = new TreeNode(1);
                q1.left = new TreeNode(2);
                q1.right = new TreeNode(3);

                System.out.println("Same Tree: " + binaryTree.isSameTree(p1, q1)); // Output: true

                // Tree p:
                // 1
                // /
                // 2

                // Tree q:
                // 1
                // \
                // 2

                TreeNode p2 = new TreeNode(1);
                p2.left = new TreeNode(2);

                TreeNode q2 = new TreeNode(1);
                q2.right = new TreeNode(2);

                System.out.println("Same Tree: " + binaryTree.isSameTree(p2, q2)); // Output: false

                // Tree p:
                // 1
                // / \
                // 2 1

                // Tree q:
                // 1
                // / \
                // 1 2

                TreeNode p3 = new TreeNode(1);
                p3.left = new TreeNode(2);
                p3.right = new TreeNode(1);

                TreeNode q3 = new TreeNode(1);
                q3.left = new TreeNode(1);
                q3.right = new TreeNode(2);

                System.out.println("Same Tree: " + binaryTree.isSameTree(p3, q3)); // Output: false

                /* ============================================== P: 44 */
                // 9. Diameter of Binary Tree
                /* ============================================== */

                // Tree:
                // 1
                // / \
                // 2 3
                // / \
                // 4 5
                root1 = new TreeNode(1);
                root1.left = new TreeNode(2);
                root1.right = new TreeNode(3);
                root1.left.left = new TreeNode(4);
                root1.left.right = new TreeNode(5);
                System.out.println("Diameter : " + binaryTree.diameterOfBinaryTree(root1)); // Output: 3

                // Tree:
                // 1
                // /
                // 2
                root2 = new TreeNode(1);
                root2.left = new TreeNode(2);
                System.out.println("Diameter : " + binaryTree.diameterOfBinaryTree(root2)); // Output: 1

                // Tree:
                // 1
                root3 = new TreeNode(1);
                System.out.println("Diameter : " + binaryTree.diameterOfBinaryTree(root3)); // Output: 0

                /* ============================================== P: 45 */
                // 10. Invert Binary Tree
                /* ============================================== */

                // Tree:
                // 4
                // / \
                // 2 7
                // / \ / \
                // 1 3 6 9
                root1 = new TreeNode(4);
                root1.left = new TreeNode(2);
                root1.right = new TreeNode(7);
                root1.left.left = new TreeNode(1);
                root1.left.right = new TreeNode(3);
                root1.right.left = new TreeNode(6);
                root1.right.right = new TreeNode(9);

                TreeNode inverted1 = binaryTree.invertTree(root1);
                System.out.println("Inverted Root (Level Order): " + binaryTree.levelOrder(inverted1));
                // Output: [4,7,2,9,6,3,1]

                // Tree:
                // 2
                // / \
                // 1 3
                root2 = new TreeNode(2);
                root2.left = new TreeNode(1);
                root2.right = new TreeNode(3);

                TreeNode inverted2 = binaryTree.invertTree(root2);
                System.out.println("Inverted Root (Level Order): " + binaryTree.levelOrder(inverted2));
                // Output: [2,3,1]

                // Tree: []
                root3 = null;
                TreeNode inverted3 = binaryTree.invertTree(root3);
                System.out.println("Inverted Root (Level Order): " + binaryTree.levelOrder(inverted3));
                // Output: []

                /* ============================================== P: 46 */
                // 11. Lowest Common Ancestor of a Binary Tree
                /* ============================================== */

                // Tree:
                // 3
                // / \
                // 5 1
                // / \ / \
                // 6 2 0 8
                // / \
                // 7 4
                TreeNode root = new TreeNode(3);
                root.left = new TreeNode(5);
                root.right = new TreeNode(1);
                root.left.left = new TreeNode(6);
                root.left.right = new TreeNode(2);
                root.right.left = new TreeNode(0);
                root.right.right = new TreeNode(8);
                root.left.right.left = new TreeNode(7);
                root.left.right.right = new TreeNode(4);

                // Example 1:
                TreeNode p = root.left; // Node with value 5
                TreeNode q = root.right; // Node with value 1
                System.out
                                .println("LCA of " + p.val + " and " + q.val + " : "
                                                + binaryTree.lowestCommonAncestor(root, p, q).val);
                // Output: 3

                // Example 2:
                p = root.left; // Node with value 5
                q = root.left.right.right; // Node with value 4
                System.out
                                .println("LCA of " + p.val + " and " + q.val + " : "
                                                + binaryTree.lowestCommonAncestor(root, p, q).val);
                // Output: 5

                // Example 3:
                root2 = new TreeNode(1);
                root2.left = new TreeNode(2);
                p = root2; // Node with value 1
                q = root2.left; // Node with value 2
                System.out.println(
                                "LCA of " + p.val + " and " + q.val + " : "
                                                + binaryTree.lowestCommonAncestor(root2, p, q).val);
                // Output: 1

        }

}
