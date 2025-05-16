package ArraysPrblm;

import java.util.Arrays;
import java.util.List;

public class ArraysCall {
    public static void Call() {
        ArraysProblem arrays = new ArraysProblem();

        /* ============================================== */
        // 1. Contains Duplicate
        /* ============================================== */
        int[] arr = { 1, 2, 3, 1 };
        boolean resBool = arrays.containsDuplicate(arr);
        System.out.println("Contains Duplicate: " + resBool); // true

        arr = new int[] { 1, 2, 3, 4 };
        resBool = arrays.containsDuplicate(arr);
        System.out.println("Contains Duplicate: " + resBool); // false

        arr = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        resBool = arrays.containsDuplicate(arr);
        System.out.println("Contains Duplicate: " + resBool); // true

        /* ============================================== */
        // 2. Missing Number
        /* ============================================== */
        arr = new int[] { 3, 0, 1 };
        int resInt = arrays.missingNumber(arr);
        System.out.println("Missing Number: " + resInt); // 2

        arr = new int[] { 0, 1 };
        resInt = arrays.missingNumber(arr);
        System.out.println("Missing Number: " + resInt); // 2

        arr = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        resInt = arrays.missingNumber(arr);
        System.out.println("Missing Number: " + resInt); // 8

        /* ============================================== */
        // 3. Find Disappeared Numbers
        /* ============================================== */
        arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> resList = arrays.findDisappearedNumbers(arr);
        System.out.print("Disappeared Numbers: ");
        print(resList); // [5, 6]

        arr = new int[] { 1, 1 };
        resList = arrays.findDisappearedNumbers(arr);
        System.out.print("Disappeared Numbers: ");
        print(resList); // [2]

        /* ============================================== */
        // 4. Two Sum
        /* ============================================== */
        int target;
        int[] resArr;

        arr = new int[] { 2, 7, 11, 15 };
        target = 9;
        resArr = arrays.twoSum(arr, target);
        System.out.println("Two Sum: " + Arrays.toString(resArr)); // [0, 1]

        arr = new int[] { 3, 2, 4 };
        target = 6;
        resArr = arrays.twoSum(arr, target);
        System.out.println("Two Sum: " + Arrays.toString(resArr)); // [1, 2]

        arr = new int[] { 3, 3 };
        target = 6;
        resArr = arrays.twoSum(arr, target);
        System.out.println("Two Sum: " + Arrays.toString(resArr)); // [0, 1]

        /* ============================================== */
        // 5. SmallerNumbersThanCurrent
        /* ============================================== */

        arr = new int[] { 8, 1, 2, 2, 3 };
        resArr = arrays.smallerNumbersThanCurrent(arr);
        System.out.println("SmallerNumbersThanCurrent: " + Arrays.toString(resArr)); // [4, 0, 1, 1, 3]

        arr = new int[] { 6, 5, 4, 8 };
        resArr = arrays.smallerNumbersThanCurrent(arr);
        System.out.println("SmallerNumbersThanCurrent: " + Arrays.toString(resArr)); // [2, 1, 0, 3]

        arr = new int[] { 7, 7, 7, 7 };
        resArr = arrays.smallerNumbersThanCurrent(arr);
        System.out.println("SmallerNumbersThanCurrent: " + Arrays.toString(resArr)); // [0, 0, 0, 0]

        /* ============================================== */
        // 6. MinTimeToVisitAllPoints
        /* ============================================== */

        int[][] arr2D = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
        resInt = arrays.minTimeToVisitAllPoints(arr2D);
        System.out.println("MinTimeToVisitAllPoints: " + resInt); // 7

        arr2D = new int[][] { { 3, 2 }, { -2, 2 } };
        resInt = arrays.minTimeToVisitAllPoints(arr2D);
        System.out.println("MinTimeToVisitAllPoints: " + resInt); // 5

        /* ============================================== */
        // 7. Spiral Matrix
        /* ============================================== */

        arr2D = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        resList = arrays.spiralOrder(arr2D);
        System.out.println("Spiral Matrix: "); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        print(resList);

        /* ============================================== */
        // 8. Number Of Islands
        /* ============================================== */

        char[][] charArr2D = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };

        resInt = arrays.numIslands(charArr2D);
        System.out.println("Number Of IsLands: " + resInt); // 1

        charArr2D = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        resInt = arrays.numIslands(charArr2D);
        System.out.println("Number Of IsLands: " + resInt); // 3

    }

    // Utility method to print a list in [a, b, c] format
    public static void print(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
        System.out.println("]");
    }
}
