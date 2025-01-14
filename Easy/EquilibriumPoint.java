class SolutionE{
    public static int findEquilibrium(int arr[]){
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Iterate through the array to find the equilibrium point
        for(int i = 0; i < arr.length; i++){
            // Calculate the right sum as totalSum - leftSum - arr[i]
            int rightSum = totalSum - leftSum - arr[i];
            
            // Check if left sum is equal to right sum
            if(leftSum == rightSum){
                return i; // Return the index if equilibrium is found
            }
            
            // Update the left sum
            leftSum += arr[i];
        }
        
        // If no equilibrium point is found, return -1
        return -1;
    }
}

public class EquilibriumPoint{
    public static void main(String[] args){
        int[] arr1 = {1, 2, 0, 3};
        System.out.println("Equilibrium Index (Example 1): " + SolutionE.findEquilibrium(arr1));
        
        int[] arr2 = {1, 1, 1, 1};
        System.out.println("Equilibrium Index (Example 2): " + SolutionE.findEquilibrium(arr2));
        
        int[] arr3 = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Equilibrium Index (Example 3): " + SolutionE.findEquilibrium(arr3));
    }
}
