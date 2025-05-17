package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {

    /*
     * 121. Best Time to Buy and Sell Stock
     * ==============================================
     * DSA: Two Pointer, Array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: Track the minimum price so far and calculate the profit if sold
     * today.
     * Update the maximum profit whenever a higher profit is found.
     *
     * You are given an array prices where prices[i] is the price of a given stock
     * on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you
     * cannot achieve any profit, return 0.
     *
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
     * 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you
     * must buy before you sell.
     *
     * Example 2:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     * Logic:
     * Use two pointers: 'left' for the buying day and 'right' for the selling day.
     * Move 'right' through the array. If prices[right] > prices[left], calculate
     * the profit and update maxProfit.
     * If prices[right] <= prices[left], move 'left' to 'right' (potential new
     * minimum).
     * Continue until the end of the array.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0; // Buy pointer
        int right = 1; // Sell pointer

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }

    /*
     * 977. Squares of a Sorted Array
     * ==============================================
     * DSA: Two Pointer, Array
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: Use two pointers at the start and end of the array. Compare the
     * squares
     * of the numbers at both ends, and place the larger square at the end of the
     * result array.
     * Move the pointer accordingly. This avoids the need to sort after squaring.
     *
     * Given an integer array nums sorted in non-decreasing order, return an array
     * of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * Example 2:
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                res[index] = leftSq;
                left++;
            } else {
                res[index] = rightSq;
                right--;
            }
            index--;
        }

        return res;
    }

    /*
     * 15. 3Sum
     * ==============================================
     * DSA: Two Pointer, Sorting
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding the output list)
     * Level: Medium
     * ==============================================
     * Intuition: Sort the array and use a fixed pointer for the first element.
     * Then use two pointers (left and right) to find pairs that sum with the fixed
     * element to zero.
     * Skip duplicates to avoid repeated triplets.
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Example 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * Example 2:
     * Input: nums = [0,1,1]
     * Output: []
     *
     * Example 3:
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            if (i > 0 && val == nums[i - 1])
                continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int accSum = val + nums[left] + nums[right];

                if (accSum > 0) {
                    right--;
                } else if (accSum < 0) {
                    left++;
                } else {

                    res.add(Arrays.asList(val, nums[left], nums[right]));
                    left++;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }

        }

        return res;

    }

    /*
     * 845. Longest Mountain in Array
     * ==============================================
     * DSA: Two Pointer, Array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Medium
     * ==============================================
     * Intuition: A mountain must strictly increase and then strictly decrease.
     * Iterate through the array and for each peak (arr[i-1] < arr[i] > arr[i+1]),
     * expand left and right to find the full mountain.
     * Track the maximum length found.
     *
     * Given an integer array arr, return the length of the longest subarray which
     * is a mountain.
     * Return 0 if there is no mountain subarray.
     *
     * A mountain is defined as:
     * - arr.length >= 3
     * - There exists some index i (0 < i < arr.length - 1) such that:
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     *
     * Example 1:
     * Input: arr = [2,1,4,7,3,2,5]
     * Output: 5
     * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
     *
     * Example 2:
     * Input: arr = [2,2,2]
     * Output: 0
     * Explanation: There is no mountain.
     */
    public int longestMountain(int[] arr) {

        int longestMoutain = 0;
        int n = arr.length;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i, right = i;

                while (left >= 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                longestMoutain = Math.max(longestMoutain, right - left + 1);
            }
        }

        return longestMoutain;
    }

}
