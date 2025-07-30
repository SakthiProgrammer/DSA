public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZero(10000233, 0));
    }

    static int countZero(int n, int count){
        if(n == 0){
            return 0;
        }
        
        if(n % 10 == 0){
            return 1;
        }

        return count + countZero(n / 10, 0);
    }
}
