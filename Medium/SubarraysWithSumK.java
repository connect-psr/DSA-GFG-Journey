import java.util.HashMap;

class SolutionFirst{   // TC: O(N^2)
    public int countSubarrays(int arr[], int k){
        int len = arr.length;
        if(arr == null || len == 0)
            return 0;
        
        int counter = 0;
        
        // Iterate through all starting points of subarrays
        for(int i = 0; i < len; ++i){
            int sum = arr[i];
            for(int j = i + 1; j < len; ++j){
                if(sum == k){
                    counter++; // Increment counter if sum matches k
                }
                sum += arr[j]; // Add the next element to the current sum
            }
            if(sum == k)
                counter++; // Check the sum for the last element
        }
        
        return counter; // Return the total count of subarrays
    }
}

class SolutionSecond{    // TC: O(N)
    public int countSubarrays(int arr[], int k){
        int len = arr.length;
        if(arr == null || len == 0)
            return 0;
        
        int counter = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with sum 0
        
        for(int i = 0; i < len; ++i){
            sum += arr[i]; // Add current element to the running sum
            
            if(map.containsKey(sum - k)){
                counter += map.get(sum - k); // Increment counter by the frequency of (sum - k)
            }
                
            // Update the frequency of the current sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return counter; // Return the total count of subarrays
    }
}

public class SubarraysWithSumK{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;

        SolutionFirst solutionFirst = new SolutionFirst();
        SolutionSecond solutionSecond = new SolutionSecond();

        int resultFirst = solutionFirst.countSubarrays(arr, k);
        int resultSecond = solutionSecond.countSubarrays(arr, k);

        System.out.println("Using SolutionFirst (O(N^2)): " + resultFirst);
        System.out.println("Using SolutionSecond (O(N)): " + resultSecond);

        // Additional test cases
        int[] testArr1 = {10, 2, -2, -20, 10};
        int testK1 = -10;

        System.out.println("Test case 1 - SolutionFirst: " + solutionFirst.countSubarrays(testArr1, testK1));
        System.out.println("Test case 1 - SolutionSecond: " + solutionSecond.countSubarrays(testArr1, testK1));

        int[] testArr2 = {1, 1, 1};
        int testK2 = 2;

        System.out.println("Test case 2 - SolutionFirst: " + solutionFirst.countSubarrays(testArr2, testK2));
        System.out.println("Test case 2 - SolutionSecond: " + solutionSecond.countSubarrays(testArr2, testK2));
    }
}
