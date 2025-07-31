public class RoatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {7, 8,10, 15, 1, 4, 5, 6};
        int target = 4;

        System.out.println(roatedBinarySearch(arr, target, 0, arr.length - 1));

    }

    static int roatedBinarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if(arr[mid] == target){
            return mid;
        }


        if(arr[start] <= arr[mid]){
            if(arr[start] >= target && arr[end] <= target){
                return roatedBinarySearch(arr, target, start, mid  - 1);
            }else{
                return roatedBinarySearch(arr, target, mid + 1, end);
            }
        }

        if(target >= arr[mid] && target <= arr[end]){
            return roatedBinarySearch(arr, target, mid + 1, end);
        }

        return roatedBinarySearch(arr, target, start, mid - 1);
    }
}
