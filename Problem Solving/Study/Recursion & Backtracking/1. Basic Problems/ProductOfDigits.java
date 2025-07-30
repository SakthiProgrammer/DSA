public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(productOfDigits(1225));
    }
 
    static int productOfDigits(int n){
        if(n == 0){
            return 1;
        }
        
        int lastDigit = n % 10;
        return lastDigit * productOfDigits(n / 10);
    }
}
