
public class Print1toN {
    public static void main(String[] args) {
        printHead(5);
        printTail(5);
    }   
    
    static void printHead(int n){
        if(n == 0){
            return;
        }

        printHead(n - 1);
        System.out.println(n);
    }

    static void printTail(int n){
        if(n == 0){
            return;
        }

        System.out.println(n);
        printTail(n - 1);
    }
}
