import java.util.HashMap;

class SolutionK{
    public int longestSubarray(int[] arr, int k){
        // HashMap to store (sum, index) pairs
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // Traverse the given array
        for(int i = 0; i < arr.length; i++){
            // Accumulate sum
            sum += arr[i];

            // When subarray starts from index 0
            if (sum == k) 
                maxLen = i + 1;

            // If 'sum' is not present in the map, add it with the index 'i'
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }

            // Check if 'sum - k' is present in the map or not
            if(map.containsKey(sum - k)){
                // Update maxLength if needed
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }

        // Return the required maximum length
        return maxLen;
    }
}

public class LongestSubarrayWithSumK{
    public static void main(String[] args){
        SolutionK solution = new SolutionK();

        int[] arr1 = {1, 2, 3, 7, 5};
        int k1 = 12;
        System.out.println("Longest Subarray Length (Example 1): " + solution.longestSubarray(arr1, k1)); // Output: 2

        int[] arr2 = {10, 5, 2, 7, 1, 9};
        int k2 = 15;
        System.out.println("Longest Subarray Length (Example 2): " + solution.longestSubarray(arr2, k2)); // Output: 4

        int[] arr3 = {-1, -1, 1, 1, 1};
        int k3 = 0;
        System.out.println("Longest Subarray Length (Example 3): " + solution.longestSubarray(arr3, k3)); // Output: 3
    }
}
