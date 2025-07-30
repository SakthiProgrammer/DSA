public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(palindrome(1221));
        System.out.println(palindrome(124321));

    }

    static boolean palindrome(int n){
        return n == reverse(n);
    }

    static int reverse(int n){
        int digit = (int) (Math.log10(n)) + 1;

        return helper(n, digit);
    }

    static int helper(int n, int digit){
        if(n % 10 == n){
            return n;
        }

        int lastDigit = n % 10;

        return lastDigit * (int) Math.pow(10, digit - 1) + helper(n / 10, digit - 1);
    }
}
