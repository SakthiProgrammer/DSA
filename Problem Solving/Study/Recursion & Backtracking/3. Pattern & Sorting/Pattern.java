public class Pattern {
    public static void main(String[] args) {
        pattern1(0,4);   
        pattern2(0, 4); 
    }

    static void pattern1(int col, int row){
        if(row == 0){
            return;
        }

        if(col != row){
            System.out.print("* ");
            pattern1(col + 1, row);
        }else{
            System.out.println();
            pattern1(0, row - 1);
        }

    }


    
    static void pattern2(int col, int row){
        if(row == 0){
            return;
        }

        if(col != row){
            pattern2(col + 1, row);
            System.out.print("* ");
        }else{
            pattern2(0, row - 1);
            System.out.println();
        }

    }
}
