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
    }
}
