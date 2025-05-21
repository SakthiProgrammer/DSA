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
    public List<String> letterCasePermutationBFS(String s) {
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

    /*
     * 77. Combinations
     * ==============================================
     * DSA: Backtracking, Combinatorics
     * Time Complexity: O(C(n, k) * k)
     * Space Complexity: O(C(n, k) * k)
     * Level: Medium
     * ==============================================
     * Intuition: Use backtracking to generate all possible combinations of k
     * numbers from 1 to n.
     * At each step, choose the next number and recursively build the combination
     * until k numbers are chosen.
     *
     * Given two integers n and k, return all possible combinations of k numbers
     * chosen from the range [1, n].
     * You may return the answer in any order.
     *
     * Example 1:
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     * Explanation: There are 4 choose 2 = 6 total combinations.
     * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to
     * be the same combination.
     *
     * Example 2:
     * Input: n = 1, k = 1
     * Output: [[1]]
     * Explanation: There is 1 choose 1 = 1 total combination.
     */

    /**
     * Generates all possible combinations of k numbers from 1 to n.
     * ----------------------------------------------
     * Logic: Backtracking to build combinations by choosing the next number and
     * recursively filling the combination.
     * Topic: Backtracking, Combinatorics
     *
     * @param n upper bound of the range (inclusive)
     * @param k number of elements in each combination
     * @return list of all possible combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, result, new ArrayList<>());
        return result;
    }

    /**
     * Helper method for generating combinations using backtracking.
     * ----------------------------------------------
     * Logic: Recursively build combinations by adding the next number and reducing
     * k.
     *
     * @param i      current starting number
     * @param n      upper bound of the range
     * @param k      numbers left to pick
     * @param result list to collect combinations
     * @param path   current combination being built
     */
    static void backtrack(int i, int n, int k, List<List<Integer>> result, List<Integer> path) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int x = i; x <= n; x++) {
            path.add(x);
            backtrack(x + 1, n, k - 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
