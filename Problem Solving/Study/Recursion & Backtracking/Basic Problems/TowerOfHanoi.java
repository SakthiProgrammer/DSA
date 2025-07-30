public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // number of disks
        solve(n, 'A', 'B', 'C'); // A = source, B = helper, C = destination
    }

    static void solve(int n, char from, char helper, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }

        // Step 1: Move n-1 disks from 'from' to 'helper'
        solve(n - 1, from, to, helper);

        // Step 2: Move nth disk to destination
        System.out.println("Move disk " + n + " from " + from + " to " + to);

        // Step 3: Move n-1 disks from 'helper' to 'to'
        solve(n - 1, helper, from, to);
    }
}
