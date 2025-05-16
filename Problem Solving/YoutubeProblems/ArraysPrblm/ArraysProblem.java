package ArraysPrblm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ArraysProblem {

    /*
     * 217. Contains Duplicate
     * ==============================================
     * DSA: Hashing, Set
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: If we see a number again while scanning, it means there's a
     * duplicate.
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
        // Logic: Use a HashSet to track seen numbers. If a number is already in the
        // set, return true.
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
     * ==============================================
     * DSA: Math, Summation
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: The sum of numbers from 0 to n is always n * (n + 1) / 2. If we
     * subtract the sum of the array from this, the missing number is revealed.
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
        // Logic: Calculate expected sum of 0..n, subtract actual sum to find missing
        // number.
        int n = nums.length;
        int expectedSum = n / 2 * (n + 1) + (n % 2) * (n + 1) / 2;// n * (n + 1) / 2; => To Prevent Overflow
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /*
     * 448. Find All Numbers Disappeared in an Array
     * ==============================================
     * DSA: Array, In-place modification
     * Time Complexity: O(n)
     * Space Complexity: O(1) (ignoring output list)
     * Level: Easy
     * ==============================================
     * Intuition: By marking indices as negative, we can track which numbers have
     * appeared. The indices left positive are the missing numbers.
     * 
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in
     * nums.
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
        // Logic: Mark indices corresponding to values as negative. The indices with
        // positive values are missing numbers.
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
     * ==============================================
     * DSA: Hashing, Map
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: If we know the target and the current number, we can check if the
     * complement has already been seen using a map.
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
        // Logic: Use a HashMap to store value:index. For each number, check if (target
        // - num) exists in the map.
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

    /*
     * 1365. How Many Numbers Are Smaller Than the Current Number
     * ==============================================
     * DSA: Sorting, Hashing
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Level: Easy
     * ==============================================
     * Intuition: Sorting the array lets us count how many numbers are smaller than
     * each value by their first index in the sorted array.
     * 
     * Given the array nums, for each nums[i] find out how many numbers in the array
     * are smaller than it. That is, for each nums[i] you have to count the number
     * of valid j's such that j != i and nums[j] < nums[i].
     * 
     * Return the answer in an array.
     * 
     * Example 1:
     * 
     * Input: nums = [8,1,2,2,3]
     * Output: [4,0,1,1,3]
     * Explanation:
     * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
     * For nums[1]=1 does not exist any smaller number than it.
     * For nums[2]=2 there exist one smaller number than it (1).
     * For nums[3]=2 there exist one smaller number than it (1).
     * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     * Example 2:
     * 
     * Input: nums = [6,5,4,8]
     * Output: [2,1,0,3]
     * Example 3:
     * 
     * Input: nums = [7,7,7,7]
     * Output: [0,0,0,0]
     * 
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Logic: Sort a copy, map each value to its first index (count of smaller
        // numbers), then build result.
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);

        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temp.length; i++) {
            int num = temp[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    /*
     * 1266. Minimum Time Visiting All Points
     * ==============================================
     * DSA: Geometry, Greedy
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Level: Easy
     * ==============================================
     * Intuition: The fastest way to move from one point to another is to move
     * diagonally as much as possible, which is the max of the x or y distance.
     * 
     * On a 2D plane, there are n points with integer coordinates points[i] = [xi,
     * yi]. Return the minimum time in seconds to visit all the points in the order
     * given by points.
     * 
     * You can move according to these rules:
     * 
     * In 1 second, you can either:
     * move vertically by one unit,
     * move horizontally by one unit, or
     * move diagonally sqrt(2) units (in other words, move one unit vertically then
     * one unit horizontally in 1 second).
     * You have to visit the points in the same order as they appear in the array.
     * You are allowed to pass through points that appear later in the order, but
     * these do not count as visits.
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: points = [[1,1],[3,4],[-1,0]]
     * Output: 7
     * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] ->
     * [1,2] -> [0,1] -> [-1,0]
     * Time from [1,1] to [3,4] = 3 seconds
     * Time from [3,4] to [-1,0] = 4 seconds
     * Total time = 7 seconds
     * 
     * Example 2:
     * 
     * Input: points = [[3,2],[-2,2]]
     * Output: 5
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        // Logic: For each consecutive pair, add max of x or y distance (diagonal moves
        // allowed).
        int totalTimeInSeconds = 0; // Total time taken to visit all points

        // Loop through each pair of consecutive points
        for (int i = 1; i < points.length; i++) {
            // Add the time taken to move from the previous point to the current point
            totalTimeInSeconds += calculateTimeBetweenTwoPoints(points[i - 1], points[i]);
        }

        return totalTimeInSeconds; // Return the total time
    }

    // Logic: Calculate the maximum of horizontal and vertical distance between two
    // points.
    static int calculateTimeBetweenTwoPoints(int[] startPoint, int[] endPoint) {
        // Calculate horizontal distance (difference in x-coordinates)
        int horizontalDistance = Math.abs(startPoint[0] - endPoint[0]);

        // Calculate vertical distance (difference in y-coordinates)
        int verticalDistance = Math.abs(startPoint[1] - endPoint[1]);

        // Minimum time is the maximum of horizontal or vertical distance,
        // because diagonal moves cover both axes in one step
        return Math.max(horizontalDistance, verticalDistance);
    }

    /*
     * 54. Spiral Matrix
     * ==============================================
     * DSA: Simulation, Matrix Traversal
     * Time Complexity: O(m * n) where m = number of rows, n = number of columns
     * Space Complexity: O(1) (ignoring output list)
     * Level: Medium
     * ==============================================
     * Intuition: By simulating the spiral movement and turning when hitting a
     * boundary or visited cell, we can collect all elements in order.
     * 
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * 
     * Example 1:
     * 
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * 
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Logic: Simulate spiral traversal by changing direction when hitting
        // boundaries or visited cells.
        int rows = matrix.length;
        int cols = matrix[0].length;

        int x = 0; // Current column index
        int y = 0; // Current row index

        int dx = 1; // Horizontal direction (start by moving right)
        int dy = 0; // Vertical direction

        List<Integer> result = new ArrayList<>();

        // Loop through all elements in the matrix
        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[y][x]); // Add current element to result
            matrix[y][x] = -101; // Mark this cell as visited using out-of-range value

            // Calculate next position
            int nextX = x + dx;
            int nextY = y + dy;

            // Check if we need to turn (out of bounds or already visited)
            if (!(0 <= nextX && nextX < cols && 0 <= nextY && nextY < rows) || matrix[nextY][nextX] == -101) {
                // Rotate direction clockwise:
                // right → down → left → up
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            // Move to the next position
            x += dx;
            y += dy;
        }

        return result; // Return spiral order traversal
    }

    /*
     * 200. Number of Islands
     * ==============================================
     * DSA: DFS, BFS, Matrix Traversal
     * Time Complexity: O(m * n) where m = number of rows, n = number of columns
     * Space Complexity: O(m * n) (due to recursion stack or visited array)
     * Level: Medium
     * ==============================================
     * Intuition: Each time we find a '1', we can use DFS to mark all connected land
     * as visited, counting one island.
     * 
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
     * '0's (water),
     * return the number of islands.
     * 
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * 
     * Example 1:
     * 
     * Input: grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 
     * Output: 1
     * 
     * Example 2:
     * 
     * Input: grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 
     * Output: 3
     */
    public int numIslands(char[][] grid) {
        // Logic: For each cell, if it's land ('1'), do DFS to mark the whole island and
        // increment count.
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    static void dfs(char[][] grid, int i, int j) {
        // Logic: Mark current cell as visited ('0'), then recursively visit all 4
        // directions.
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        // Mark as Visited
        grid[i][j] = '0';
        // Move Right
        dfs(grid, i, j + 1);
        // Move Left
        dfs(grid, i, j - 1);
        // Move Down
        dfs(grid, i + 1, j);
        // Move Top
        dfs(grid, i - 1, j);
    }
}