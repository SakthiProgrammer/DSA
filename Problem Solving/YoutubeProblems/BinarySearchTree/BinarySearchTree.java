package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Utility.TreeNode;

public class BinarySearchTree {

    /**
     * 700. Search in a Binary Search Tree
     * ==============================================
     * Level: Easy
     * Tags: Tree, Binary Search Tree, Recursion, Iteration
     * ==============================================
     * Problem:
     * You are given the `root` of a binary search tree (BST) and an integer `val`.
     * Find the node in the BST that the node's value equals `val` and return the
     * subtree rooted with that node.
     * If such a node does not exist, return `null`.
     *
     * Example 1:
     * Input: root = [4,2,7,1,3], val = 2
     * Output: [2,1,3]
     * Explanation: The node with value 2 is found and the subtree rooted at it is
     * returned.
     *
     * Example 2:
     * Input: root = [4,2,7,1,3], val = 5
     * Output: []
     * Explanation: No node with value 5 exists in the tree.
     *
     * Approach:
     * - Since the tree is a Binary Search Tree (BST), we leverage its properties:
     * - If `val` is less than the current node's value, we search the left subtree.
     * - If `val` is greater, we search the right subtree.
     * - If `val` equals the current node's value, we return the current node.
     * - We use an iterative approach to avoid recursion stack overhead.
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        while (root != null) {
            if (root.val == val) {
                return root; // Node found
            } else if (root.val < val) {
                root = root.right; // Move to right subtree
            } else {
                root = root.left; // Move to left subtree
            }
        }

        return null; // Node not found
    }

    /**
     * 701. Insert into a Binary Search Tree
     * ==============================================
     * Level: Medium
     * Tags: Tree, Binary Search Tree, Recursion, Iteration
     * ==============================================
     * Problem:
     * You are given the root node of a binary search tree (BST) and a value to
     * insert into the tree.
     * Return the root node of the BST after the insertion. It is guaranteed that
     * the new value does not exist in the original BST.
     *
     * Approach (Iterative):
     * - Start from the root and traverse the tree.
     * - If the value to insert is less than the current node’s value, go left.
     * - If the value is greater, go right.
     * - When a null child is found, insert the new node there.
     *
     * Example:
     * Input: root = [4,2,7,1,3], val = 5
     * Output: [4,2,7,1,3,5]
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root;

        while (true) {
            if (curr.val < val) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    /**
     * 701. Insert into a Binary Search Tree (Recursive Version)
     * ==============================================
     * Level: Medium
     * Tags: Tree, Binary Search Tree, Recursion
     * ==============================================
     * Problem:
     * Same as above – insert a value into a BST and return the updated root node.
     *
     * Approach (Recursive):
     * - Use recursion to traverse the tree until a null spot is found.
     * - Insert the new node at the correct position.
     * - Return the updated tree with recursive attachments.
     *
     * Example:
     * Input: root = [4,2,7,1,3], val = 5
     * Output: [4,2,7,1,3,5]
     */
    public TreeNode insertIntoBSTRecur(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBSTRecur(root.left, val);
        else
            root.right = insertIntoBSTRecur(root.right, val);
        return root;
    }

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * ==============================================
     * Level: Easy
     * Tags: Tree, DFS, Binary Search Tree
     * ==============================================
     * Problem:
     * Given an integer array `nums` where the elements are sorted in ascending
     * order,
     * convert it to a height-balanced binary search tree (BST).
     *
     * A height-balanced BST is a binary tree in which the depth of the two subtrees
     * of every node never differs by more than one.
     *
     * Example 1:
     * Input: nums = [-10,-3,0,5,9]
     * Output: [0,-3,9,-10,null,5]
     * Explanation: [0,-3,9,-10,null,5] is one possible result.
     *
     * Example 2:
     * Input: nums = [1,3]
     * Output: [1,null,3]
     *
     * Approach:
     * - Use recursion to construct the tree.
     * - Choose the middle element as root to maintain balance.
     * - Recursively apply the same logic to the left and right subarrays.
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return getBst(nums, 0, nums.length - 1);
    }

    /**
     * Recursively builds a height-balanced BST from a sorted subarray.
     *
     * @param arr      The sorted array
     * @param startIdx Starting index of the current subarray
     * @param endIdx   Ending index of the current subarray
     * @return TreeNode representing the root of the BST/subtree
     */
    public static TreeNode getBst(int arr[], int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        int mid = (startIdx + endIdx) / 2;
        TreeNode bst = new TreeNode(arr[mid]);

        // Recursively build left and right subtrees
        bst.left = getBst(arr, startIdx, mid - 1);
        bst.right = getBst(arr, mid + 1, endIdx);

        return bst;
    }

    /**
     * 653. Two Sum IV - Input is a BST
     * ==============================================
     * Level: Easy
     * Tags: Tree, BFS, HashSet
     * ==============================================
     * Problem:
     * Given the root of a Binary Search Tree (BST) and an integer k, return true
     * if there exist two elements in the BST such that their sum is equal to k.
     *
     * Example 1:
     * Input: root = [5,3,6,2,4,null,7], k = 9
     * Output: true
     * Explanation: 2 + 7 = 9 exists in the tree.
     *
     * Example 2:
     * Input: root = [5,3,6,2,4,null,7], k = 28
     * Output: false
     *
     * Approach:
     * - Use BFS to traverse the tree level-by-level.
     * - Use a HashSet to store values seen so far.
     * - For each node, check if `k - node.val` exists in the set.
     * - If it does, we've found two values summing to k → return true.
     * - If traversal finishes without finding the pair → return false.
     */
    public boolean findTarget(TreeNode root, int k) {
        // Initialize queue for BFS and set to store visited values
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Check if complement of current value exists
            if (set.contains(k - node.val))
                return true;

            // Add current node value to set
            set.add(node.val);

            // Add left and right children to queue if they exist
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false; // No such pair found
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * ==============================================
     * Level: Medium
     * Tags: Tree, Binary Search Tree
     * ==============================================
     * Problem:
     * Given a Binary Search Tree (BST), find the lowest common ancestor (LCA) of
     * two given nodes `p` and `q` in the BST.
     * 
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the
     * lowest node in T that has both p and q
     * as descendants (where we allow a node to be a descendant of itself).
     * 
     * Example 1:
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * 
     * Example 2:
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
     * of itself.
     * 
     * Approach:
     * - Since this is a BST, we can use its properties to efficiently find the LCA.
     * - If both `p` and `q` are greater than `root`, go right.
     * - If both `p` and `q` are less than `root`, go left.
     * - Otherwise, current `root` is the LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right; // both nodes are in right subtree
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left; // both nodes are in left subtree
            } else {
                return root; // one node on each side, or one matches root
            }
        }
        return null; // should not reach here if both nodes are guaranteed to exist
    }

    /**
     * 530. Minimum Absolute Difference in BST
     * ==============================================
     * Level: Easy
     * Tags: Tree, DFS, BST, Inorder Traversal
     * ==============================================
     * Problem:
     * Given the root of a Binary Search Tree (BST), return the minimum absolute
     * difference between the values of any two different nodes in the tree.
     *
     * Approach:
     * - Perform an in-order traversal of the BST to get nodes in sorted order.
     * - Keep track of the previous visited node to compute the difference.
     * - Update the minimum difference encountered so far.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * Space Complexity: O(H), where H is the height of the tree (due to the stack).
     */
    public int getMinimumDifference(TreeNode node) {
        int diff = Integer.MAX_VALUE;

        if (node == null)
            return diff;

        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;

        // Iterative In-order traversal
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }

            TreeNode popped = stk.pop();

            // If previous node exists, calculate the difference
            if (prev != null) {
                diff = Math.min(diff, popped.val - prev.val);
            }

            prev = popped;
            node = popped.right;
        }

        return diff;
    }

    /**
     * 1382. Balance a Binary Search Tree
     * ==============================================
     * Level: Medium
     * Tags: Tree, BST, DFS, Inorder Traversal, Divide and Conquer
     * ==============================================
     * Problem:
     * Given the root of a binary search tree (BST), return a balanced BST
     * with the same node values. A BST is balanced if the depths of the two
     * subtrees of every node never differ by more than 1.
     *
     * Examples:
     * Example 1:
     * Input: root = [1,null,2,null,3,null,4,null,null]
     * Output: [2,1,3,null,null,null,4]
     * Explanation: This is not the only correct answer,
     * [3,1,4,null,2] is also correct.
     *
     * Example 2:
     * Input: root = [2,1,3]
     * Output: [2,1,3]
     *
     * Approach:
     * - Perform an inorder traversal to collect nodes in sorted order.
     * - Construct a balanced BST recursively by choosing the middle node
     * of the sorted list as root.
     * - Recursively build left and right subtrees from left and right halves.
     *
     * Time Complexity: O(N), where N is the number of nodes (inorder + tree
     * building).
     * Space Complexity: O(N), for storing nodes and recursion stack.
     */
    List<TreeNode> sortedArr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root); // Step 1: Get all nodes in sorted (inorder) order.
        return sortedArrayToBST(0, sortedArr.size() - 1); // Step 2: Build balanced BST.
    }

    void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }

    TreeNode sortedArrayToBST(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }
}
