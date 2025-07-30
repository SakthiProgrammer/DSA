public class Main{
    public static void main(String[] a){
        
        // 1. Print Hello World 5 times
        message(5);
        messageRev(5);

        //2. Print 1 to 5 
        print(5);
    }


    // 1. these is tail resursion
    static void message(int n){
        if(n == 0){
            return;
        }

        System.out.println(6 - n+ ". Hello World");
        message(n - 1); // tail resursion
    }

    // these are head recursion
    static void messageRev(int n){
        if(n == 0){
            return;
        }

        message(n - 1); // head recursion
        System.out.println(6 - n+ ". Hello World");
    }


    static void print(int n){
        if(n == 0){
            return;
        }

        print(n - 1);
        System.out.println(n);
    }


}