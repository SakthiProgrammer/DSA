package DynamicProgramming;

public class DynamincProgramming {

    /*
     * 322. Coin Change
     * ==============================================
     * DSA: Dynamic Programming
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     * Level: Medium
     * ==============================================
     * Intuition: Use DP to build up the minimum coins needed for each amount from 0
     * to target.
     * For each amount, try every coin and take the minimum.
     *
     * You are given an integer array coins representing coins of different
     * denominations and an integer amount.
     * Return the fewest number of coins needed to make up that amount. If it cannot
     * be made up, return -1.
     * You may assume you have an infinite number of each kind of coin.
     *
     * Example 1:
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     *
     * Example 2:
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     * Example 3:
     * Input: coins = [1], amount = 0
     * Output: 0
     */
    public int coinChange(int[] coins, int amount) {

        int n = amount + 1;
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = n;
        }

        for (int amt = 0; amt < n; amt++) {
            for (int coin : coins) {
                if (amt - coin >= 0) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /*
     * 70. Climbing Stairs
     * ==============================================
     * DSA: Dynamic Programming
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: The number of ways to reach the nth step is the sum of the ways to
     * reach (n-1) and (n-2) steps.
     * This is the Fibonacci sequence. Use two variables to keep track of previous
     * results for O(1) space.
     *
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can
     * you climb to the top?
     *
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */
    public int climbStairs(int n) {
        int n1 = 0, n2 = 1;

        for (int i = 0; i < n; i++) {
            int temp = n1;
            n1 = n2;
            n2 = temp + n2;
        }

        return n2;
    }

    /*
     * 53. Maximum Subarray
     * ==============================================
     * DSA: Dynamic Programming, Array
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: Use dynamic programming to keep track of the maximum subarray sum
     * ending at each index.
     * At each position, decide whether to start a new subarray at the current
     * element or extend the previous subarray.
     * The answer is the largest value found.
     *
     * In simple terms: For each element, you either start a new sum from that
     * element or add it to the previous sum,
     * whichever is bigger. Keep track of the biggest sum you see.
     *
     * Given an integer array nums, find the subarray with the largest sum, and
     * return its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     *
     * Example 3:
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // Initialize the first element
        int max = dp[0]; // Track the maximum sum

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /*
     * 338. Counting Bits
     * ==============================================
     * DSA: Dynamic Programming, Bit Manipulation
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: For each number i, the number of 1's in its binary representation
     * is
     * 1 plus the number of 1's in (i - largest power of 2 less than or equal to i).
     * Use dynamic programming to build up the answer for each i.
     *
     * Given an integer n, return an array ans of length n + 1 such that for each i
     * (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     *
     * Example 1:
     * Input: n = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     *
     * Example 2:
     * Input: n = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < dp.length; i++) {
            if (offset * 2 == i) {
                offset = i;
            }

            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }

    /*
     * 303. Range Sum Query - Immutable
     * ==============================================
     * DSA: Prefix Sum, Array
     * Time Complexity: O(1) per query, O(n) preprocessing
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: Use a prefix sum array to quickly compute the sum of any subarray.
     * Precompute the prefix sums so that each range sum query can be answered in
     * constant time.
     *
     * Given an integer array nums, handle multiple queries of the following type:
     * - Calculate the sum of the elements of nums between indices left and right
     * inclusive where left <= right.
     * Implement the NumArray class:
     * NumArray(int[] nums): Initializes the object with the integer array nums.
     * int sumRange(int left, int right): Returns the sum of the elements of nums
     * between indices left and right inclusive.
     *
     * Example 1:
     * Input
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * Output
     * [null, 1, -1, -3]
     *
     * Explanation
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
     * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
     * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
     */
    class NumArray {

        int[] prefixNums;

        public NumArray(int[] nums) {
            prefixNums = nums;

            for (int i = 1; i < nums.length; i++) {
                prefixNums[i] += prefixNums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0)
                return prefixNums[right];
            return prefixNums[right] - prefixNums[left - 1];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}
