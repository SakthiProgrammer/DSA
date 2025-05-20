package BackTracking;

import Utility.MethodCall;
import java.util.List;

public class BackTrackingCall implements MethodCall {

    @Override
    public void call() {

        BackTracking backTracking = new BackTracking();

        /* ============================================== P: 20 */
        // 1. Letter Case Permutation
        /* ============================================== */
        String s = "a1b2";
        List<String> resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutation(s);
        System.out.println("Letter Case Permutation: " + resList); // [3z4, 3Z4]

        /* ============================================== P: 21 */
        // 2. Letter Case Permutation (Queue/BFS)
        /* ============================================== */
        s = "a1b2";
        resList = backTracking.letterCasePermutationQueue(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [a1b2, a1B2, A1b2, A1B2]

        s = "3z4";
        resList = backTracking.letterCasePermutationQueue(s);
        System.out.println("Letter Case Permutation (Queue): " + resList); // [3z4, 3Z4]

        /* ============================================== P: 22 */
        // 3. Subsets
        /* ============================================== */
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

        arr = new int[] { 0 };
        resList2 = backTracking.subsets(arr);
        System.out.println("Subsets: " + resList2); // [[], [0]]
    }
}
