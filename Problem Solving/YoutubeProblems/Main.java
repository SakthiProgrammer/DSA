import ArraysPrblm.ArraysCall;
import BackTracking.BackTrackingCall;
import BitManipulation.BitManipulationCall;
import DynamicProgramming.DynamicProgrammingCall;
import LinkedList.LinkedListCall;
import SlidingWindow.SlidingWindowCall;
import TwoPointer.TwoPointerCall;
import Utility.MethodCall;

public class Main {
    public static void main(String[] args) {

        /*
         * ========================================================================
         * 
         * todo: Process for Problem Solving I Use in LeetCode
         * =============================================
         * 
         * Read the problem twice to understand it - (ask clarifying questions)
         * Try think basically of different ways to solve problem
         * Think end-to-end (E2E) of the best solutions based on complexity
         * Write the algorithm from patterns in drawing
         * Code it out
         * Try and improve it once you think you're finished
         * Go through other solutions (even if you answered correctly).
         * 
         * =========================================================================
         */

        MethodCall method = null;

        /*
         * ==============================================
         * 1. Arrays Problems (P): (1 - 8) = 8
         * ==============================================
         */
        method = new ArraysCall();
        method.call();

        /*
         * ==============================================
         * 2. Two Pointer Problems (P): (9 - 12) = 4
         * ==============================================
         */
        method = new TwoPointerCall();
        method.call();

        /*
         * ==============================================
         * 3. Sliding Window Problems (P): (13 - 15) = 3
         * ==============================================
         */
        method = new SlidingWindowCall();
        method.call();

        /*
         * ==============================================
         * 4. Bit Manipulation Problems (P): (13 - 15) = 3
         * ==============================================
         */
        method = new BitManipulationCall();
        method.call();

        /*
         * ==============================================
         * 5. Dynamic Programming Problems (P): (16 - 19) = 4
         * ==============================================
         */
        method = new DynamicProgrammingCall();
        method.call();

        /*
         * ==============================================
         * 6. Backtracking Problems (P): (20 - 25) = 5
         * ==============================================
         */
        method = new BackTrackingCall();
        method.call();

        /*
         * ==============================================
         * 6. Linked List Problems (P): (26 - ) = 5
         * ==============================================
         */
        method = new LinkedListCall();
        method.call();

    }
}
