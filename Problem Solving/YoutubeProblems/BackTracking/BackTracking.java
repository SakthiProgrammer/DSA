package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTracking {

    /*
     * 784. Letter Case Permutation
     * ==============================================
     * DSA: Backtracking, String
     * Time Complexity: O(2^n * n), where n is the number of letters in s
     * Space Complexity: O(2^n * n)
     * Level: Medium
     * ==============================================
     * Intuition: For each character, if it's a letter, branch into both lowercase
     * and uppercase.
     * If it's a digit, keep it as is. Build all possible combinations using
     * backtracking or iterative expansion.
     *
     * Given a string s, you can transform every letter individually to be lowercase
     * or uppercase to create another string.
     * Return a list of all possible strings we could create. Return the output in
     * any order.
     *
     * Example 1:
     * Input: s = "a1b2"
     * Output: ["a1b2","a1B2","A1b2","A1B2"]
     *
     * Example 2:
     * Input: s = "3z4"
     * Output: ["3z4","3Z4"]
     */

    /**
     * Generates all possible strings by changing each letter in the input string to
     * lowercase and uppercase.
     * Digits remain unchanged.
     * ----------------------------------------------
     * Logic: Iterative Expansion (Backtracking Topic)
     * For each character, expand all current possibilities by branching on case if
     * it's a letter.
     *
     * @param s input string
     * @return list of all possible letter case permutations
     */
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        output.add(""); // base case

        for (int i = 0; i < s.length(); i++) {
            List<String> temp = new ArrayList<>();
            char curr = s.charAt(i);

            if (Character.isLetter(curr)) {
                // If current character is a letter, branch into both lowercase and uppercase
                for (String str : output) {
                    temp.add(str + Character.toLowerCase(curr));
                    temp.add(str + Character.toUpperCase(curr));
                }
            } else {
                // If current character is a digit, keep it as is
                for (String str : output) {
                    temp.add(str + curr);
                }
            }
            output = temp;
        }
        return output;
    }

    /**
     * Generates all possible strings by changing each letter in the input string to
     * lowercase and uppercase using a queue (BFS approach).
     * Digits remain unchanged.
     * ----------------------------------------------
     * Intuition: Treat each letter as a branching point—at every letter, create two
     * new strings:
     * one with the lowercase version and one with the uppercase version. Use a
     * queue to
     * systematically expand all possibilities level by level, similar to BFS.
     * Logic: Breadth-First Search (BFS) using a queue (Backtracking Topic)
     * For each letter, expand all current possibilities by branching on case.
     *
     * @param s input string
     * @return list of all possible letter case permutations
     */
    public List<String> letterCasePermutationQueue(String s) {
        LinkedList<String> result = new LinkedList<>();
        result.add(s);

        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                int size = result.size();

                while (size-- > 0) {
                    String S = result.poll();
                    String left = S.substring(0, i);
                    String right = S.substring(i + 1, n);
                    result.add(left + Character.toLowerCase(c) + right);
                    result.add(left + Character.toUpperCase(c) + right);
                }
            }
        }
        return result;
    }

    /*
     * 78. Subsets
     * ==============================================
     * DSA: Backtracking, Array
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * Level: Medium
     * ==============================================
     * Intuition: Use backtracking to explore all possible combinations (subsets).
     * At each step, decide to include or exclude the current element.
     *
     * Given an integer array nums of unique elements, return all possible subsets
     * (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in
     * any order.
     *
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * Example 2:
     * Input: nums = [0]
     * Output: [[],[0]]
     */

    /**
     * Returns all possible subsets (the power set) of the given array.
     * ----------------------------------------------
     * Logic: Backtracking (DFS) to explore all subset combinations.
     * Topic: Backtracking, Array
     *
     * @param nums array of unique integers
     * @return list of all subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0, new ArrayList<>());
        return res;
    }

    /**
     * Helper method for generating subsets using backtracking.
     * ----------------------------------------------
     * Logic: Recursively build subsets by including or excluding each element.
     *
     * @param nums   input array
     * @param output list to collect subsets
     * @param index  current index in nums
     * @param curr   current subset being built
     */
    static void backtrack(int[] nums, List<List<Integer>> output, int index, List<Integer> curr) {
        output.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, output, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
