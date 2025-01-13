class SolutionM{
    public int maxWater(int arr[]){
        // Check if the input array is valid
        if(arr == null || arr.length < 2){
            return 0;
        }
        
        int left = 0; // Start pointer
        int right = arr.length - 1; // End pointer
        int maxWater = 0; // Variable to store the maximum water
        
        // Two-pointer approach
        while(left < right){
            // Calculate the width of the container
            int width = right - left;
            // Calculate the height as the minimum of the two heights
            int height = Math.min(arr[left], arr[right]);
            // Update maxWater if the current area is larger
            maxWater = Math.max(maxWater, width * height);
            
            // Move the pointer pointing to the smaller height
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        
        return maxWater;
    }
}

public class ContainerWithMostWater{
    public static void main(String[] args){
        SolutionM solution = new SolutionM();
        
        // Example test cases
        int[] arr1 = {1, 5, 4, 3};
        System.out.println("Max Water (Example 1): " + solution.maxWater(arr1)); // Output: 6
        
        int[] arr2 = {3, 1, 2, 4, 5};
        System.out.println("Max Water (Example 2): " + solution.maxWater(arr2)); // Output: 12
        
        int[] arr3 = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println("Max Water (Example 3): " + solution.maxWater(arr3)); // Output: 25
    }
}
