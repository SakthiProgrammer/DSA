package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Utility.TreeNode;

public class BinaryTree {

    /*
     * 637. Average of Levels in Binary Tree
     * ==============================================
     * DSA: Tree, BFS (Level Order Traversal), Queue
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – For the queue storing nodes at each level.
     * Level: Easy
     * ==============================================
     * Intuition:
     * Perform level-order traversal using a queue.
     * For each level, calculate the sum of node values and then take the average.
     * Append the average to the result list.
     *
     * You are given the root of a binary tree.
     * Return the average value of the nodes on each level in the form of a list.
     * Answers within 10^-5 of the actual answer will be accepted.
     *
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [3.00000, 14.50000, 11.00000]
     * Explanation:
     * - Level 0: [3] => Average = 3
     * - Level 1: [9, 20] => Average = (9 + 20) / 2 = 14.5
     * - Level 2: [15, 7] => Average = (15 + 7) / 2 = 11
     *
     * Example 2:
     * Input: root = [3,9,20,15,7]
     * Output: [3.00000, 14.50000, 11.00000]
     */

    public List<Double> averageOfLevels(TreeNode root) {
        // Initialize a queue for level-order traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>(List.of(root));

        // List to store the average of each level
        List<Double> ans = new ArrayList<>();

        // Continue level-order traversal until the queue is empty
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int qlen = q.size();

            // Variable to store the sum of node values at this level
            double row = 0;

            // Process each node in the current level
            for (int i = 0; i < qlen; i++) {
                TreeNode curr = q.poll(); // Remove the node from the queue
                row += curr.val; // Add its value to the sum

                // Add left and right children (if present) to the queue for the next level
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }

            // Compute the average for this level and add to the result list
            ans.add(row / qlen);
        }

        // Return the list of averages for each level
        return ans;
    }

    /*
     * 111. Minimum Depth of Binary Tree
     * ==============================================
     * DSA: Tree, BFS (Level Order Traversal), Queue
     * Time Complexity: O(n) – Each node is visited at most once.
     * Space Complexity: O(n) – For the queue used in level-order traversal.
     * Level: Easy
     * ==============================================
     * Intuition:
     * Perform a level-order (BFS) traversal.
     * The first time we encounter a leaf node (no left or right child),
     * we return the current level as it represents the minimum depth.
     *
     * You are given the root of a binary tree.
     * Return its minimum depth – the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     *
     * A leaf is a node with no children.
     *
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     * Explanation: The shortest path to a leaf is [3, 9], which has depth 2.
     *
     * Example 2:
     * Input: root = [2,null,3,null,4,null,5,null,6]
     * Output: 5
     * Explanation: The shortest path to a leaf is [2,3,4,5,6], which has depth 5.
     */
    public int minDepth(TreeNode root) {
        // If the tree is empty, return depth 0
        if (root == null) {
            return 0;
        }

        // Initialize queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        int level = 1; // Start from level 1 (root level)

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            // Process all nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // If a leaf node is found, return the current level as the minimum depth
                if (node.left == null && node.right == null) {
                    return level;
                }

                // Add left child to queue if it exists
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child to queue if it exists
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Move to the next level
            level++;
        }

        return 0; // This line is never reached due to tree structure constraints
    }

    /*
     * 104. Maximum Depth of Binary Tree
     * ==============================================
     * DSA: Tree, BFS (Level Order Traversal), DFS (alternative)
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – For the queue used in level-order traversal.
     * Level: Easy
     * ==============================================
     * Intuition:
     * Perform a level-order (BFS) traversal.
     * Increment the level counter each time we complete a level.
     * The total number of levels represents the maximum depth.
     *
     * You are given the root of a binary tree.
     * Return its maximum depth – the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     *
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * Explanation: The longest path is [3 → 20 → 15] or [3 → 20 → 7], depth = 3.
     *
     * Example 2:
     * Input: root = [1,null,2]
     * Output: 2
     * Explanation: The longest path is [1 → 2], depth = 2.
     */
    public int maxDepth(TreeNode root) {
        // If the tree is empty, depth is 0
        if (root == null) {
            return 0;
        }

        // Initialize queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        int level = 0; // Track the depth level

        // Traverse level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes in the current level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Add left and right children to the queue if they exist
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Increase depth after finishing a level
            level++;
        }

        // Return the maximum depth
        return level;
    }

    /**
     * Maximum Value in a Binary Tree
     * ==============================================
     * DSA: Tree, BFS (Level Order Traversal)
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – For the queue used in level-order traversal.
     * Level: Custom (Not a LeetCode problem)
     * ==============================================
     * Intuition:
     * Use level-order traversal (BFS) to visit each node.
     * Keep track of the maximum value encountered.
     * At the end of the traversal, return the maximum value.
     *
     * You are given the root of a binary tree.
     * Return the maximum node value present in the tree.
     *
     * Example:
     * Input: root = [5,1,9,null,null,4,13]
     * Output: 13
     * Explanation: The largest value among all nodes is 13.
     */
    public int maxValue(TreeNode root) {
        // Initialize queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        int maxValue = Integer.MIN_VALUE; // Track the maximum value found

        // Traverse level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Update maxValue if the current node's value is larger
                maxValue = Math.max(maxValue, curr.val);

                // Add children to the queue for next level processing
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        // Return the maximum value found in the tree
        return maxValue;
    }

    /**
     * Finds the minimum value in a binary tree.
     * ==============================================
     * DSA: Tree, BFS (Level Order Traversal)
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – For the queue used in level-order traversal.
     * Level: Custom Utility (Not a LeetCode question)
     * ==============================================
     * Intuition:
     * - Use level-order traversal (BFS) to visit every node.
     * - Keep track of the minimum value encountered while traversing.
     * - Return the smallest node value found in the tree.
     */
    public int minValue(TreeNode root) {
        // If the tree is empty, return 0 as a fallback
        if (root == null) {
            return 0;
        }

        // Initialize the queue with the root node for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));

        // Start with the maximum possible value to find the minimum
        int minValue = Integer.MAX_VALUE;

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at current level

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll(); // Remove the current node

                // Update minimum value if current node is smaller
                minValue = Math.min(minValue, curr.val);

                // Add left and right children to the queue if they exist
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        // Return the smallest value found in the tree
        return minValue;
    }

    /**
     * Finds the minimum value in a binary tree using DFS (iterative with stack).
     * ==================================================
     * DSA: Tree, DFS (Depth-First Search using Stack)
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – Stack stores up to n nodes in the worst case.
     * Level: Easy
     * ==================================================
     * Intuition:
     * - Use a stack for iterative DFS traversal.
     * - At each step, compare node values and track the minimum.
     *
     */
    public int minValueDFS(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, return 0 as a fallback
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int minValue = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // Update the minimum value
            minValue = Math.min(minValue, node.val);

            // Push right child first so left is processed first (standard DFS)
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return minValue;
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * ==============================================
     * DSA: Tree, BFS (Breadth-First Search)
     * Time Complexity: O(n) – Each node is visited once.
     * Space Complexity: O(n) – For the queue and result list.
     * Level: Medium
     * ==============================================
     * Problem:
     * Given the root of a binary tree, return the level order traversal of its
     * nodes' values.
     * That is, return the values of the nodes level by level from left to right.
     *
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3], [9,20], [15,7]]
     *
     * Example 2:
     * Input: root = [1]
     * Output: [[1]]
     *
     * Example 3:
     * Input: root = []
     * Output: []
     *
     * Intuition:
     * - Use a queue to perform level-order traversal (BFS).
     * - For each level, iterate over all nodes at that level,
     * collect their values, and add their children to the queue.
     * - Append each level’s result to the final output list.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            res.add(level);
        }

        return res;
    }

    /**
     * 112. Path Sum
     * ==============================================
     * Level: Easy
     * Tags: Tree, DFS
     * ==============================================
     * Problem:
     * Given the root of a binary tree and an integer targetSum, return true
     * if the tree has a root-to-leaf path such that adding up all the values
     * along the path equals targetSum.
     *
     * A leaf is a node with no children.
     *
     * Example 1:
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * Output: true
     * Explanation: The root-to-leaf path 5 → 4 → 11 → 2 has a sum of 22.
     *
     * Example 2:
     * Input: root = [1,2,3], targetSum = 5
     * Output: false
     * Explanation: Paths 1→2 (sum 3) and 1→3 (sum 4) do not match targetSum.
     *
     * Example 3:
     * Input: root = [], targetSum = 0
     * Output: false
     * Explanation: Tree is empty, so no paths exist.
     *
     * Approach:
     * - Use DFS to explore each path from root to leaf.
     * - Accumulate the sum as we go deeper.
     * - If a leaf node is reached, check if the accumulated sum equals targetSum.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    /**
     * Helper method to recursively compute path sum.
     * 
     * @param root      Current node
     * @param targetSum Target sum to reach
     * @param currSum   Current accumulated sum
     * @return True if a valid path exists
     */
    private boolean pathSum(TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return false;
        }

        currSum += root.val;

        // Check if it’s a leaf node
        if (root.left == null && root.right == null) {
            return currSum == targetSum;
        }

        // Recurse down to children
        return pathSum(root.left, targetSum, currSum) || pathSum(root.right, targetSum, currSum);
    }

    /**
     * 100. Same Tree
     * Difficulty: Easy
     * 
     * Given the roots of two binary trees `p` and `q`, this method checks
     * if they are the same tree.
     *
     * Two binary trees are considered the same if:
     * - They have the same structure.
     * - The corresponding nodes have the same values.
     *
     * @param p the root node of the first binary tree
     * @param q the root node of the second binary tree
     * @return true if both trees are identical, false otherwise
     *
     *         Examples:
     *
     *         Example 1:
     *         Input: p = [1,2,3], q = [1,2,3]
     *         Output: true
     *
     *         Example 2:
     *         Input: p = [1,2], q = [1,null,2]
     *         Output: false
     *
     *         Example 3:
     *         Input: p = [1,2,1], q = [1,1,2]
     *         Output: false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = depth(node.left); // recursively find depth of left subtree
        int rightDepth = depth(node.right); // recursively find depth of right subtree

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth); // update diameter

        return 1 + Math.max(leftDepth, rightDepth); // return depth of current node
    }

    /*
     * 226. Invert Binary Tree
     * Difficulty: Easy
     * 
     * Given the root of a binary tree, invert the tree (mirror it),
     * and return its root.
     * 
     * Example 1:
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * Explanation:
     * 4 4
     * / \ => / \
     * 2 7 7 2
     * / \ / \ / \ / \
     * 1 3 6 9 9 6 3 1
     * 
     * Example 2:
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     * Explanation:
     * 2 => 2
     * / \ / \
     * 1 3 3 1
     * 
     * Example 3:
     * Input: root = []
     * Output: []
     * 
     * Approach:
     * - Use an iterative DFS with a stack to traverse the tree.
     * - At each node, swap its left and right children.
     * - Push the children into the stack to continue traversal.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr != null) {
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                stack.push(curr.right);
                stack.push(curr.left);
            }
        }

        return root;
    }

    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * ==============================================
     * Level: Medium
     * Tags: Tree, DFS, Binary Tree
     * ==============================================
     * Problem:
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
     * in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the
     * lowest node in T
     * that has both p and q as descendants (where we allow a node to be a
     * descendant of itself)
     *
     * Example 1:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     *
     * Example 2:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5 (a node is allowed to be a
     * descendant of itself).
     *
     * Example 3:
     * Input: root = [1,2], p = 1, q = 2
     * Output: 1
     *
     * Approach:
     * - Use BFS to map each node to its parent using a HashMap.
     * - Traverse from node p to root, storing all ancestors in a HashSet.
     * - Traverse from node q upward until a node appears in the HashSet — that's
     * the LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Map to store each node's parent
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from the root
        queue.add(root);
        map.put(root, null); // root has no parent

        // Traverse until both nodes p and q are found and their parents are recorded
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode curr = queue.poll();

            // If left child exists, add to queue and map its parent
            if (curr.left != null) {
                map.put(curr.left, curr);
                queue.add(curr.left);
            }

            // If right child exists, add to queue and map its parent
            if (curr.right != null) {
                map.put(curr.right, curr);
                queue.add(curr.right);
            }
        }

        // Set to store ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();

        // Add all ancestors of p to the set
        while (p != null) {
            ancestors.add(p);
            p = map.get(p); // move to parent
        }

        // Traverse ancestors of q until we find a common one in p's ancestor set
        while (!ancestors.contains(q)) {
            q = map.get(q); // move to parent
        }

        // The first common ancestor found is the LCA
        return q;
    }

}
