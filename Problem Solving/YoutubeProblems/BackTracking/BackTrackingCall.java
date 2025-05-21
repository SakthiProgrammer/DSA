package BackTracking;

import Utility.MethodCall;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingCall implements MethodCall {

    @Override
    public void call() {

        BackTracking backTracking = new BackTracking();

        /* ============================================== P: 20 */
        // 1. Letter Case Permutation
        /* ============================================== */
        String s = "a1b2";
        List<String> resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [3z4, 3Z4]

        /* ============================================== P: 21 */
        // 2. Letter Case Permutation (Queue/BFS)
        /* ============================================== */
        s = "a1b2";
        resList = backTracking.letterCasePermutationBFS(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutationBFS(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [3z4, 3Z4]

        /* ============================================== P: 22 */
        // 3. Subsets
        /* ============================================== */
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

        arr = new int[] { 0 };
        resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [0]]

        /* ============================================== P: 23 */
        // 4. Combinations
        /* ============================================== */
        int n = 4, k = 2;
        resList2 = backTracking.combine(n, k);
        System.out.println("Combinations: " + resList2); // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

        n = 1;
        k = 1;
        resList2 = backTracking.combine(n, k);
        System.out.println("Combinations: " + resList2); // [[1]]
    }

    /*
     * 46. Permutations
     * ==============================================
     * DSA: Backtracking, Recursion
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n * n!)
     * Level: Medium
     * ==============================================
     * Intuition: Use backtracking to generate all possible orderings (permutations)
     * of the array.
     * For each element, fix it at the current position and recursively permute the
     * remaining elements.
     *
     * Given an array nums of distinct integers, return all the possible
     * permutations. You can return the answer in any order.
     *
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * Example 2:
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     *
     * Example 3:
     * Input: nums = [1]
     * Output: [[1]]
     */

    /**
     * Returns all possible permutations of the given array.
     * ----------------------------------------------
     * Logic: For each element, fix it and recursively permute the rest.
     * 1. If the array has only one element, return it as the only permutation.
     * 2. For each element in the array:
     * - Pick the element as the current fixed element.
     * - Create a new array without this element.
     * - Recursively get all permutations of the smaller array.
     * - Add the fixed element to each of these permutations.
     * - Collect all permutations in the result list.
     * 3. Return the result list.
     *
     * @param nums array of distinct integers
     * @return list of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            // Base case: only one element, return as the only permutation
            List<Integer> singleList = new ArrayList<>();
            singleList.add(nums[0]);
            res.add(singleList);
            return res;
        }

        // For each element in nums
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // Create a new array without the current element
            int[] remainingNums = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remainingNums[index] = nums[j];
                    index++;
                }
            }

            // Recursively get all permutations of the remaining elements
            List<List<Integer>> perms = permute(remainingNums);

            // Add the current element to each permutation
            for (List<Integer> p : perms) {
                p.add(n);
            }

            // Add all new permutations to the result
            res.addAll(perms);
        }

        return res;
    }

}
