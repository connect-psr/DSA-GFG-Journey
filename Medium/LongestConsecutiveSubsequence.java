import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] arr){
        int len = arr.length;
        
        if(arr == null || len == 0){
            return 0;
        }
        
        Arrays.sort(arr); // Sort the array to compare consecutive elements
        int longest = 1, temp = 1;
        
        for(int i = 1; i < len; ++i){
            // Skip duplicates
            if(arr[i] == arr[i-1])
                continue;
            // If consecutive, increment the temp counter
            else if(arr[i] == arr[i-1] + 1)
                temp++;
            // If not consecutive, update longest and reset temp
            else{
                longest = Math.max(longest, temp);
                temp = 1;
            }
        }
        
        return Math.max(longest, temp);
    }
}

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {100, 4, 200, 1, 3, 2}; // Sample input
        System.out.println("Longest Consecutive Subsequence Length: " + solution.longestConsecutive(arr));
    }
}
