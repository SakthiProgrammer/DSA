package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SlidingWindow {

    /*
     * 219. Contains Duplicate II
     * ==============================================
     * DSA: Sliding Window, Hashing
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, k))
     * Level: Easy
     * ==============================================
     * Intuition: Use a HashSet to keep track of the last k elements seen.
     * If a duplicate is found within the window of size k, return true.
     * Otherwise, slide the window forward by removing the oldest element.
     *
     * Given an integer array nums and an integer k, return true if there are two
     * distinct indices i and j in the array such that nums[i] == nums[j] and
     * abs(i - j) <= k.
     *
     * Example 1:
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     *
     * Example 2:
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     *
     * Example 3:
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (seen.contains(num)) {
                return true;
            }

            seen.add(num);

            if (seen.size() > k) {
                seen.remove(nums[i - k]);
            }
        }

        return false;

    }

    /*
     * 1200. Minimum Absolute Difference
     * ==============================================
     * DSA: Sorting, Array
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: Sort the array to bring closest numbers together.
     * The minimum absolute difference will be between adjacent elements.
     * Iterate through the sorted array to find the minimum difference,
     * then collect all pairs with that difference.
     *
     * Given an array of distinct integers arr, find all pairs of elements with the
     * minimum absolute difference of any two elements.
     * Return a list of pairs in ascending order (with respect to pairs), each pair
     * [a, b] follows:
     * - a, b are from arr
     * - a < b
     * - b - a equals to the minimum absolute difference of any two elements in arr
     *
     * Example 1:
     * Input: arr = [4,2,1,3]
     * Output: [[1,2],[2,3],[3,4]]
     * Explanation: The minimum absolute difference is 1. List all pairs with
     * difference equal to 1 in ascending order.
     *
     * Example 2:
     * Input: arr = [1,3,6,10,15]
     * Output: [[1,3]]
     *
     * Example 3:
     * Input: arr = [3,8,-10,23,19,-4,-14,27]
     * Output: [[-14,-10],[19,23],[23,27]]
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int num1 = arr[i - 1];
            int num2 = arr[i];
            if (num2 - num1 == minDiff) {
                res.add(Arrays.asList(num1, num2));
            }
        }

        return res;
    }

    /*
     * 209. Minimum Size Subarray Sum
     * ==============================================
     * DSA: Sliding Window, Array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Medium
     * ==============================================
     * Intuition: Use a sliding window to maintain a subarray sum.
     * Expand the window by moving the end pointer and add elements to the sum.
     * When the sum is greater than or equal to target, shrink the window from the
     * start
     * to find the minimal length.
     *
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or equal to
     * target. If there is no such subarray, return 0 instead.
     *
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem
     * constraint.
     *
     * Example 2:
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Example 3:
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     */
    public int minSubArrayLen(int target, int[] nums) {

        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (currentSum >= target) {

                minSize = Math.min(minSize, end + 1 - start);
                currentSum -= nums[start];

                start++;
            }

        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;

    }

}
