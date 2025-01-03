import java.util.HashMap;

class SolutionA{
    public long subarrayXor(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, prefixXOR = 0;
        
        map.put(0, 1); // Initialize with 0 XOR count to handle edge cases
        
        for(int a : arr){
            prefixXOR ^= a; // Compute the running XOR
            
            int target = prefixXOR ^ k; // Calculate the required XOR to form subarray
            
            if(map.containsKey(target))
                count += map.get(target); // Add the count of subarrays with the target XOR
                
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1); // Update the map with current XOR
        }
        
        return count;
    }
}

public class CountSubarraysWithGivenXOR{
    public static void main(String[] args){
        SolutionA solution = new SolutionA();
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(solution.subarrayXor(arr, k));
    }
}
