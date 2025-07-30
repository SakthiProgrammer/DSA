public class Sum1ToN {
    public static void main(String[] args) {
        System.out.println(sum1ToN(10));
    }

    static int sum1ToN(int n){
        if(n == 1){
            return 1;
        }

        return n + sum1ToN(n - 1);
    }
}
