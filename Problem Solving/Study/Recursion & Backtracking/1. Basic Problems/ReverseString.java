
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));

    }    

    static String reverseString(String str) {
        char[] strarr = str.toCharArray();
        int n = str.length();

        reverseString(strarr, 0, n - 1);
        return new String(strarr);
    }

    static void reverseString(char[] charArr, int left, int right){
        if(left >= right){
            return;
        }

        char temp = charArr[left];
        charArr[right] = charArr[left];
        charArr[right] = temp;

        reverseString(charArr, left + 1, right - 1);
    }
}
