package BackTracking;

import Utility.MethodCall;

import java.util.List;

public class BackTrackingCall implements MethodCall {

    @Override
    public void call() {

        BackTracking backTracking = new BackTracking();

        /* ============================================== P: 21 */
        // 1. Letter Case Permutation
        /* ============================================== */
        String s = "a1b2";
        List<String> resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [3z4, 3Z4]

        /* ============================================== P: 22 */
        // 2. Letter Case Permutation (Queue/BFS)
        /* ============================================== */
        s = "a1b2";
        resList = backTracking.letterCasePermutationBFS(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutationBFS(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [3z4, 3Z4]

        /* ============================================== P: 23 */
        // 3. Subsets
        /* ============================================== */
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

        arr = new int[] { 0 };
        resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [0]]

        /* ============================================== P: 24 */
        // 4. Combinations
        /* ============================================== */
        int n = 4, k = 2;
        resList2 = backTracking.combine(n, k);
        System.out.println("Combinations: " + resList2); // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

        n = 1;
        k = 1;
        resList2 = backTracking.combine(n, k);
        System.out.println("Combinations: " + resList2); // [[1]]

        /* ============================================== P: 25 */
        // 5. Permutations
        /* ============================================== */
        arr = new int[] { 1, 2, 3 };
        resList2 = backTracking.permute(arr);
        System.out.println("Permutations: " + resList2); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3,
                                                         // 2, 1]]

        arr = new int[] { 0, 1 };
        resList2 = backTracking.permute(arr);
        System.out.println("Permutations: " + resList2); // [[0, 1], [1, 0]]

        arr = new int[] { 1 };
        resList2 = backTracking.permute(arr);
        System.out.println("Permutations: " + resList2); // [[1]]
    }

}
