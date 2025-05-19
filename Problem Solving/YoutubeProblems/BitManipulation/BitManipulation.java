package BitManipulation;

public class BitManipulation {

    /*
     * 136. Single Number
     * ==============================================
     * DSA: Bit Manipulation, Array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: XOR all numbers together. Pairs cancel out (x ^ x = 0), so the result is the single number.
     *
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Example 1:
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Example 2:
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     * Example 3:
     * Input: nums = [1]
     * Output: 1
     */
    public int singleNumber(int[] nums) {

        int singleNum = 0;

        for (int i = 0; i < nums.length; i++) {

            singleNum = singleNum ^ nums[i]; // xor operator(bitwise operator) - bit manipulation

        }

        return singleNum;
    }
}
