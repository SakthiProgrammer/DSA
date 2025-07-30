public class SortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sortedArray(nums, 0));
    }

    static boolean sortedArray(int[] nums, int n){
        if(n == nums.length - 1){
            return true;
        }

        return nums[n] < nums[n + 1] && sortedArray(nums, n + 1);
    }
}
