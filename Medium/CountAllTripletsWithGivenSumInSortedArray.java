class SolutionB {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length, count = 0;
        if (arr == null || n < 3) {
            return 0; // Return 0 if arr is null or arr size less than 3
        }
        
        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == target) { // Check if the current triplet matches the target
                    int lValue = arr[left];
                    int rValue = arr[right];
                    
                    int lCount = 0, rCount = 0;
                    
                    // Count duplicates on the left
                    while (left <= right && arr[left] == lValue) {
                        left++;
                        lCount++;
                    }
                    // Count duplicates on the right
                    while (left <= right && arr[right] == rValue) {
                        right--;
                        rCount++;
                    }
                    
                    // If all triplets have the same middle value
                    if (lValue == rValue) {
                        count += (lCount * (lCount - 1)) / 2;
                    } else {
                        count += lCount * rCount;
                    }
                } else if (sum > target) {
                    right--; // Decrease right pointer for smaller sum
                } else {
                    left++; // Increase left pointer for larger sum
                }
            }
        }
        return count;
    }
}

public class CountAllTripletsWithGivenSumInSortedArray
{
    public static void main(String[] args) {
        SolutionB solution = new SolutionB();
        int[] arr = {1, 2, 2, 3, 4};
        int target = 7;
        System.out.println(solution.countTriplets(arr, target));
    }
}
