
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(122));
    }    

    static int sum(int n){
        if(n == 0){
            return 0;
        }

        int lastDigit = n % 10;
        return lastDigit + sum(n / 10);
    }
}
