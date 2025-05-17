package TwoPointer;

import java.util.Arrays;

import Utility.MethodCall;

public class TwoPointerCall implements MethodCall {

    @Override
    public void call() {
        TwoPointer twoPointer = new TwoPointer();

        /* ============================================== P: 9 */
        // 1. Best Time to Buy and Sell Stock
        /* ============================================== */
        int[] intArr = new int[] { 7, 1, 5, 3, 6, 4 };
        int resInt = twoPointer.maxProfit(intArr);
        System.out.println("Max Profit: " + resInt); // 5

        intArr = new int[] { 7, 6, 4, 3, 1 };
        resInt = twoPointer.maxProfit(intArr);
        System.out.println("Max Profit: " + resInt); // 0

        /* ============================================== P: 10 */
        // 2. Squares of a Sorted Array
        /* ============================================== */
        intArr = new int[] { -4, -1, 0, 3, 10 };
        int[] resArr = twoPointer.sortedSquares(intArr);
        System.out.println("Sorted Squares: " + Arrays.toString(resArr)); // [0, 1, 9, 16, 100]

        intArr = new int[] { -7, -3, 2, 3, 11 };
        resArr = twoPointer.sortedSquares(intArr);
        System.out.println("Sorted Squares: " + Arrays.toString(resArr)); // [4, 9, 9, 49, 121]

        /* ============================================== P: 11 */
        // 3. 3Sum
        /* ============================================== */
        intArr = new int[] { -1, 0, 1, 2, -1, -4 };
        var resList = twoPointer.threeSum(intArr);
        System.out.println("3Sum Triplets: " + resList); // [[-1, -1, 2], [-1, 0, 1]]

        intArr = new int[] { 0, 1, 1 };
        resList = twoPointer.threeSum(intArr);
        System.out.println("3Sum Triplets: " + resList); // []

        intArr = new int[] { 0, 0, 0 };
        resList = twoPointer.threeSum(intArr);
        System.out.println("3Sum Triplets: " + resList); // [[0, 0, 0]]

        /* ============================================== P: 12 */
        // 4. Longest Mountain in Array
        /* ============================================== */

        intArr = new int[] { 2, 1, 4, 7, 3, 2, 5 };
        resInt = twoPointer.longestMountain(intArr);
        System.out.println("Longest Mountain: " + resInt); // 5

        intArr = new int[] { 2, 2, 2 };
        resInt = twoPointer.longestMountain(intArr);
        System.out.println("Longest Mountain: " + resInt); // 0
    }
}
