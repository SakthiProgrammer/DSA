package DynamicProgramming;

import DynamicProgramming.DynamincProgramming.NumArray;
import Utility.MethodCall;

public class DynamicProgrammingCall implements MethodCall {

    @Override
    public void call() {
        DynamincProgramming dp = new DynamincProgramming();

        /* ============================================== P: 17 */
        // 1. Coin Change
        /* ============================================== */
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int resInt = dp.coinChange(coins, amount);
        System.out.println("Coin Change: " + resInt); // 3

        coins = new int[] { 2 };
        amount = 3;
        resInt = dp.coinChange(coins, amount);
        System.out.println("Coin Change: " + resInt); // -1

        coins = new int[] { 1 };
        amount = 0;
        resInt = dp.coinChange(coins, amount);
        System.out.println("Coin Change: " + resInt); // 0

        /* ============================================== P: 18 */
        // 2. Maximum Subarray
        /* ============================================== */
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        resInt = dp.maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + resInt); // 6

        arr = new int[] { 1 };
        resInt = dp.maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + resInt); // 1

        arr = new int[] { 5, 4, -1, 7, 8 };
        resInt = dp.maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + resInt); // 23

        /* ============================================== P: 19 */
        // 3. Counting Bits
        /* ============================================== */
        int n = 2;
        int[] resArr = dp.countBits(n);
        System.out.println("Counting Bits: " + java.util.Arrays.toString(resArr)); // [0, 1, 1]

        n = 5;
        resArr = dp.countBits(n);
        System.out.println("Counting Bits: " + java.util.Arrays.toString(resArr)); // [0, 1, 1, 2, 1, 2]

        /* ============================================== P: 20 */
        // 4. Range Sum Query - Immutable (NumArray)
        /* ============================================== */
        int[] nums = { -2, 0, 3, -5, 2, -1 };

        NumArray numArray = dp.new NumArray(nums);

        System.out.println("NumArray sumRange(0, 2): " + numArray.sumRange(0, 2)); // 1
        System.out.println("NumArray sumRange(2, 5): " + numArray.sumRange(2, 5)); // -1
        System.out.println("NumArray sumRange(0, 5): " + numArray.sumRange(0, 5)); // -3
    }

}
