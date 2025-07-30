
public class Product1ToN{
    public static void main(String[] args) {
        System.out.println(product1ToN(10));
    }

    static int product1ToN(int n){
        if(n == 1){
            return 1;
        }

        return n * product1ToN(n - 1);
    }
}