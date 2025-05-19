package SlidingWindow;

import Utility.MethodCall;

public class SlidingWindowCall implements MethodCall {

    @Override
    public void call() {
        SlidingWindow slidingWindow = new SlidingWindow();

        /* ============================================== P: 13 */
        // 1. Contains Duplicate II
        /* ============================================== */
        int[] arr = { 1, 2, 3, 1 };
        int k = 3;
        boolean resBool = slidingWindow.containsNearbyDuplicate(arr, k);
        System.out.println("Contains Nearby Duplicate: " + resBool); // true

        arr = new int[] { 1, 0, 1, 1 };
        k = 1;
        resBool = slidingWindow.containsNearbyDuplicate(arr, k);
        System.out.println("Contains Nearby Duplicate: " + resBool); // true

        arr = new int[] { 1, 2, 3, 1, 2, 3 };
        k = 2;
        resBool = slidingWindow.containsNearbyDuplicate(arr, k);
        System.out.println("Contains Nearby Duplicate: " + resBool); // false

        /* ============================================== P: 14 */
        // 2. Minimum Absolute Difference
        /* ============================================== */
        int[] arr2 = { 4, 2, 1, 3 };
        var resList2 = slidingWindow.minimumAbsDifference(arr2);
        System.out.println("Minimum Absolute Difference: " + resList2); // [[1, 2], [2, 3], [3, 4]]

        arr2 = new int[] { 1, 3, 6, 10, 15 };
        resList2 = slidingWindow.minimumAbsDifference(arr2);
        System.out.println("Minimum Absolute Difference: " + resList2); // [[1, 3]]

        arr2 = new int[] { 3, 8, -10, 23, 19, -4, -14, 27 };
        resList2 = slidingWindow.minimumAbsDifference(arr2);
        System.out.println("Minimum Absolute Difference: " + resList2); // [[-14, -10], [19, 23], [23, 27]]

        /* ============================================== P: 15 */
        // 3. Minimum Size Subarray Sum
        /* ============================================== */
        int target = 7;
        arr2 = new int[] { 2, 3, 1, 2, 4, 3 };
        int resInt = slidingWindow.minSubArrayLen(target, arr2);
        System.out.println("Minimum Size Subarray Length: " + resInt); // 2

        target = 4;
        arr2 = new int[] { 1, 4, 4 };
        resInt = slidingWindow.minSubArrayLen(target, arr2);
        System.out.println("Minimum Size Subarray Length: " + resInt); // 1

        target = 11;
        arr2 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        resInt = slidingWindow.minSubArrayLen(target, arr2);
        System.out.println("Minimum Size Subarray Length: " + resInt); // 0

    }

}
