package BinarySearchTree;

import Utility.MethodCall;
import Utility.TreeNode;
import Utility.Utility;

public class BinarySearchTreeCall implements MethodCall {

    @Override
    public void call() {
        BinarySearchTree bst = new BinarySearchTree();

        /*
         * ================================================= P: 47
         * // 1. Search in Binary Search Tree
         * =============================================
         */

        // Tree:
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        TreeNode result1 = bst.searchBST(root1, 2);
        System.out.println("Subtree Rooted at 2 (Level Order): " + Utility.levelOrder(result1));
        // Output: [2,1,3]

        TreeNode result2 = bst.searchBST(root1, 5);
        System.out.println("Subtree Rooted at 5 (Level Order): " + Utility.levelOrder(result2));
        // Output: []

        /*
         * ============================================== P: 48
         * 2. Insert into Binary Search Tree
         * ==============================================
         */

        // Input Tree:
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        int insertVal1 = 5;
        TreeNode insertedIterative = bst.insertIntoBST(root1, insertVal1);
        System.out.println("BST after Iterative Insert (Level Order): " + Utility.levelOrder(insertedIterative));
        // Output: [4,2,7,1,3,5]

        // Input Tree:
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);

        int insertVal2 = 6;
        TreeNode insertedRecursive = bst.insertIntoBSTRecur(root2, insertVal2);
        System.out.println("BST after Recursive Insert (Level Order): " + Utility.levelOrder(insertedRecursive));
        // Output: [4,2,7,1,3,6]

        /*
         * ============================================== P: 49
         * 3. Convert Sorted Array to Binary Search Tree
         * ==============================================
         */

        int[] nums1 = { -10, -3, 0, 5, 9 };
        TreeNode bst1 = bst.sortedArrayToBST(nums1);
        System.out.println("BST from nums1 (Level Order): " + Utility.levelOrder(bst1));
        // Output: [0, -3, 9, -10, null, 5]

        int[] nums2 = { 1, 3 };
        TreeNode bst2 = bst.sortedArrayToBST(nums2);
        System.out.println("BST from nums2 (Level Order): " + Utility.levelOrder(bst2));
        // Output: [1, null, 3]

        int[] nums3 = {};
        TreeNode bst3 = bst.sortedArrayToBST(nums3);
        System.out.println("BST from nums3 (Level Order): " + Utility.levelOrder(bst3));
        // Output: []

        /*
         * ============================================== P: 50
         * 4. Two Sum IV - Input is a BST
         * ==============================================
         */

        // Tree:
        // 5
        // / \
        // 3 6
        // / \ \
        // 2 4 7
        root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);

        System.out.println("Output: " + bst.findTarget(root1, 9));
        // Output: true (Because 2 + 7 = 9)

        System.out.println("Output: " + bst.findTarget(root1, 28));
        // Output: false (No such pair exists)

        /*
         * ============================================== P: 51
         * 5. Lowest Common Ancestor of a Binary Search Tree
         * ==============================================
         */

        // Tree:
        // 6
        // / \
        // 2 8
        // / \ / \
        // 0 4 7 9
        // / \
        // 3 5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Case 1: LCA of 2 and 8
        TreeNode p1 = root.left; // Node 2
        TreeNode q1 = root.right; // Node 8
        TreeNode lca1 = bst.lowestCommonAncestor(root, p1, q1);
        System.out.println("LCA of 2 and 8: " + lca1.val); // Output: 6

        // Case 2: LCA of 2 and 4
        TreeNode p2 = root.left; // Node 2
        TreeNode q2 = root.left.right; // Node 4
        TreeNode lca2 = bst.lowestCommonAncestor(root, p2, q2);
        System.out.println("LCA of 2 and 4: " + lca2.val); // Output: 2

        // Case 3: LCA of 3 and 5
        TreeNode p3 = root.left.right.left; // Node 3
        TreeNode q3 = root.left.right.right; // Node 5
        TreeNode lca3 = bst.lowestCommonAncestor(root, p3, q3);
        System.out.println("LCA of 3 and 5: " + lca3.val); // Output: 4

        /*
         * ============================================== P: 52
         * 6. Minimum Absolute Difference in BST
         * ==============================================
         */

        // Tree:
        // 4
        // / \
        // 2 6
        // / \
        // 1 3
        root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        int resInt = bst.getMinimumDifference(root1);
        System.out.println("Minimum Absolute Difference: " + resInt);
        // Output: 1

        // Tree:
        // 1
        // \
        // 5
        // /
        // 3
        root2 = new TreeNode(1);
        root2.right = new TreeNode(5);
        root2.right.left = new TreeNode(3);

        resInt = bst.getMinimumDifference(root2);
        System.out.println("Minimum Absolute Difference: " + resInt);
        // Output: 2

        // Tree: []
        TreeNode root3 = null;
        resInt = bst.getMinimumDifference(root3);
        System.out.println("Minimum Absolute Difference: " + resInt);
        // Output: 2147483647 (Integer.MAX_VALUE, since no valid difference exists)

        /*
         * ============================================== P: 53
         * 7. Balance a Binary Search Tree
         * ==============================================
         */

        // Tree:
        // 1
        // \
        // 2
        // \
        // 3
        // \
        // 4
        root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        root1.right.right.right = new TreeNode(4);

        TreeNode balanced1 = bst.balanceBST(root1);
        System.out.println("Balanced BST (Inorder): " + Utility.levelOrder(balanced1));
        // Output (Inorder): [1, 2, 3, 4]

        // Tree:
        // 2
        // / \
        // 1 3
        root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        TreeNode balanced2 = bst.balanceBST(root2);
        System.out.println("Balanced BST (Inorder): " + Utility.levelOrder(balanced2));
        // Output (Inorder): [1, 2, 3]

        // Tree: []
        root3 = null;

        TreeNode balanced3 = bst.balanceBST(root3);
        System.out.println("Balanced BST (Inorder): " + Utility.levelOrder(balanced3));
        // Output: []

    }

}
