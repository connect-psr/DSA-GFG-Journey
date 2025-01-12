class Solution{
    public int maxWater(int arr[]){
        // Edge case: If array is null or has less than 3 elements, no water can be trapped
        if(arr == null || arr.length < 3){
            return 0;
        }

        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        // Two-pointer approach
        while(left <= right){
            if(arr[left] <= arr[right]){
                // Update leftMax or add trapped water at the left pointer
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                }else{
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            }else{
                // Update rightMax or add trapped water at the right pointer
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                }else{
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }
}
public class TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        int result = solution.maxWater(heights);
        System.out.println("Maximum water that can be trapped: " + result);
    }
}
