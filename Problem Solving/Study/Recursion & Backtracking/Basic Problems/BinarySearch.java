public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {2, 4, 6, 10, 112};
        int target = 6;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println(result);
    }

    static int binarySearch(int[] arr, int left, int right, int target){
        if(left > right){
            return -1;
        }

        int mid = left + (right - left) / 2;
        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] <= target){
            return binarySearch(arr, mid + 1, right, target);
        }else{
            return binarySearch(arr, left, mid - 1, target);
        }
    }
}
