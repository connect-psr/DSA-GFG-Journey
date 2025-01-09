import java.util.ArrayList;

class SolutionZ{
    static ArrayList<Integer> subarraySum(int[] arr, int target){
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        if(arr == null || n == 0 || target == 0){
            result.add(-1); // If the array is null, empty, or target is 0, return -1
            return result;
        }

        int start = 0, sum = 0;

        for(int end = 0; end < n; end++){
            sum += arr[end]; // Add current element to the running sum

            while(sum > target && start <= end){
                sum -= arr[start]; // Remove elements from the start until sum <= target
                start++;
            }

            if(sum == target){
                result.add(start + 1); // 1-based index for start
                result.add(end + 1);   // 1-based index for end
                return result;
            }
        }

        result.add(-1); // If no subarray is found, return -1
        return result;
    }
}

public class IndexesOfSubarraySum{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 7, 5}; // Example input array
        int target = 12;             // Example target sum

        ArrayList<Integer> result = SolutionZ.subarraySum(arr, target);

        if(result.size() == 1 && result.get(0) == -1){
            System.out.println("No subarray with the given sum found.");
        }else{
            System.out.println("Subarray with the given sum is found between indexes: " + result);
        }
    }
}
