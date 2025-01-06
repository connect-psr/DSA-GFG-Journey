import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class SolutionE{
    public List<Integer> sumClosest(int[] arr, int target){
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length < 2){
            return result;
        }
        
        Arrays.sort(arr);
        int left = 0, right = arr.length-1, closeDiff = Integer.MAX_VALUE;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);
            
            if(diff < closeDiff){
                closeDiff = diff; // Update the closest difference
                result.clear(); // Clear previous results
                result.add(arr[left]); // Add the pair with the closest sum
                result.add(arr[right]);
            }
            
            if(sum == target){
                return result;
            
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        
        return result;
    }
}
public class SumPairClosestToTarget{
    public static void main(String[] args) {
        SolutionE solution = new SolutionE();
        int arr[] = {5, 2, 7, 1, 4};
        int target = 10;
        // Get the closest pair
        List<Integer> result = solution.sumClosest(arr, target);

        if(!result.isEmpty()){
            System.out.println("Closest pair to target " + target + " is: " + result);
        }else{
            System.out.println("No valid pair found.");
        }
    }
}
