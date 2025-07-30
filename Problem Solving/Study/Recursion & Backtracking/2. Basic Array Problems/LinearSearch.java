public class LinearSearch {
    public static void main(String[] args) {
        int nums[] = {1, 4,1,10, 4};
        System.out.println(linearSearch(nums, 0, 10));

    }

    static int linearSearch(int[] arr, int index, int target){

        if(index >= arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return linearSearch(arr, index + 1, target);
    }
}
