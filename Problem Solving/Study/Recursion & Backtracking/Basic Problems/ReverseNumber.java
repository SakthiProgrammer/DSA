public class ReverseNumber {


    static int sum = 0;
    public static void main(String[] args) {
        reverseNumber(122);
        System.out.println(sum);

        System.out.println(reverse2(122));
    }

    // 1. Using a result outside of the functions
    static int reverseNumber(int n){
        if(n == 0){
            return 0;
        }

        int lastDigit = n % 10;

        sum = sum * 10 + lastDigit;
        return reverseNumber(n / 10);
    }

    // 2. Using a result inside the function using helper

    static int reverse2(int n){
        int digit = (int) (Math.log10(n) + 1);
        
        return helper(n, digit);
    }

    static int helper(int n, int digit){
        if(n % 10 == n){
            return n;
        }

        int lastDigit = n % 10;
        return lastDigit * (int) (Math.pow(10, digit - 1)) + helper(n / 10, digit - 1);
    }
}
