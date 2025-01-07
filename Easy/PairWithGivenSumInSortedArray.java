import java.util.Arrays;

class Solution{
    int countPairs(int arr[], int target) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        
        Arrays.sort(arr);
        
        int left  = 0, right = arr.length -1, count = 0;
    
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum == target){
                if(arr[left] == arr[right]){
                    // If both numbers are the same, the number of pairs is combination of elements
                    int n = right - left + 1;
                    count += n * (n - 1) / 2;
                    break;
                }
                
                int lCount = 1, rCount = 1;
                
                while(left + 1 < right && arr[left] == arr[left+1]){
                    left++;
                    lCount++;
                }
                while(right - 1 > left && arr[right] == arr[right-1]){
                    right--;
                    rCount++;
                }
                
                count += lCount * rCount;
                left++;
                right--;
                
            }else if(sum > target){
                right--;
                
            }else{
                left++;
            }
        }
        
        return count;
    }
}
public class PairWithGivenSumInSortedArray{
    public static void main(String[]a){
        Solution solution = new Solution();
        int []arr = {-1, 1, 5, 5, 7};
        int target = 6;
        System.out.println("Result: "+solution.countPairs(arr, target));
    }
}
