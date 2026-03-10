import java.util.*;

public class Problem9_TwoSum {

    public static void findTwoSum(int[] arr, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){

            int complement = target - arr[i];

            if(map.containsKey(complement)){
                System.out.println("Pair: " + complement + " + " + arr[i]);
            }

            map.put(arr[i],i);
        }
    }

    public static void main(String[] args){

        int[] nums = {500,300,200};
        findTwoSum(nums,500);
    }
}