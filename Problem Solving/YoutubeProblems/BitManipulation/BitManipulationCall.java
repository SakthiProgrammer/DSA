package BitManipulation;

import Utility.MethodCall;

public class BitManipulationCall implements MethodCall {

    @Override
    public void call() {
        BitManipulation bitManipulation = new BitManipulation();

        /* ============================================== P: 1 */
        // 1. Single Number
        /* ============================================== */
        int[] arr = { 2, 2, 1 };
        int resInt = bitManipulation.singleNumber(arr);
        System.out.println("Single Number: " + resInt); // 1

        arr = new int[] { 4, 1, 2, 1, 2 };
        resInt = bitManipulation.singleNumber(arr);
        System.out.println("Single Number: " + resInt); // 4

        arr = new int[] { 1 };
        resInt = bitManipulation.singleNumber(arr);
        System.out.println("Single Number: " + resInt); // 1
    }

}
