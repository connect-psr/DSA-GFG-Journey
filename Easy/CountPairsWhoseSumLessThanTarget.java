import java.util.Arrays;

class Solution {
    int countPairs(int arr[], int target) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        
        int count = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length - 1; ++i){
            if(arr[i] + arr[i] >= target)
                break;
            for(int j = i+1; j < arr.length; ++j){
                if(arr[i] + arr[j] < target)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}

public class CountPairsWhoseSumLessThanTarget{
    public static void main(String[] args){
        Solution solution = new Solution();

        int[] arr = {1, 3, 5, 2, 4};
        int target = 6;

        int result = solution.countPairs(arr, target);
        System.out.println("Number of pairs: " + result);
    }
}