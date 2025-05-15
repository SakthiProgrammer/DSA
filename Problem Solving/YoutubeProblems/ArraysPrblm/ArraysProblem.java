package ArraysPrblm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArraysProblem {

    /*
     * 217. Contains Duplicate
     * 
     * Given an integer array nums, return true if any value appears at least twice
     * in the array, and return false if every element is distinct.
     * 
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: true
     * 
     * Example 2:
     * Input: nums = [1,2,3,4]
     * Output: false
     * 
     * Example 3:
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     */
    public boolean containsDuplicate(int[] nums) {
        // Logic: Use a HashSet to track seen numbers. If a number is already in the set, return true.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /*
     * 268. Missing Number
     * 
     * Given an array nums containing n distinct numbers in the range [0, n], return
     * the only number in the range that is missing from the array.
     * 
     * Example 1:
     * Input: nums = [3,0,1]
     * Output: 2
     * 
     * Example 2:
     * Input: nums = [0,1]
     * Output: 2
     * 
     * Example 3:
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     */
    public int missingNumber(int[] nums) {
        // Logic: Calculate expected sum of 0..n, subtract actual sum to find missing number.
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /*
     * 448. Find All Numbers Disappeared in an Array
     * 
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     * 
     * Example 1:
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     * 
     * Example 2:
     * Input: nums = [1,1]
     * Output: [2]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Logic: Mark indices corresponding to values as negative. The indices with positive values are missing numbers.
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /*
     * 1. Two Sum
     * 
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * 
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * 
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * 
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    public int[] twoSum(int[] nums, int target) {
        // Logic: Use a HashMap to store value:index. For each number, check if (target - num) exists in the map.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return null; // No solution found (should not happen as per problem statement)
    }
}