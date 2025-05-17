package Utility;

import java.util.List;

public class Utility {
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
