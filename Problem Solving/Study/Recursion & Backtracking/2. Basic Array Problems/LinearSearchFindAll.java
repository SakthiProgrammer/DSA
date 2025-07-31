import java.util.*;

class LinearSearchFindAll{
    public static void main(String[] args) {
        
        // 1. Returning a ArrayList taking res inside a argument
        int[] arr = {1,2,3,1,2,1};
        int target = 1;
        ArrayList<Integer> ans = linearSearch(arr, target, 0, new ArrayList<>());
        System.out.println(ans);

        // 2. Returning a ArrayList without res taking inside a argument
        ArrayList<Integer> ans2 = linearSearch(arr, target, 0);
        System.out.println(ans2);

    }

    static ArrayList<Integer> linearSearch(int[] arr, int target, int index, ArrayList<Integer> ans){
        if(index == arr.length){
            return ans;
        }

        if(arr[index] == target){
            ans.add(index);
        }

        return linearSearch(arr, target, index + 1, ans);
    }

    static ArrayList<Integer> linearSearch(int[] arr, int target, int index){

        ArrayList<Integer> ans = new ArrayList<>();

        if(index == arr.length){
            return ans;
        }

        if(arr[index] == target){
            ans.add(index);
        }

        ArrayList<Integer> bellowCallsAns = linearSearch(arr, target, index + 1);

        ans.addAll(bellowCallsAns);

        return ans;

    }
}