import java.util.Arrays;

class Solution{
    static int countTriangles(int arr[]){
        if(arr == null || arr.length < 3){
            return 0; // If less than 3 elements, no triangle can be formed
        }

        Arrays.sort(arr); // Sort the array to apply two-pointer technique
        int n = arr.length, count = 0;

        // Optimized approach with TC: O(N^2)
        for(int i = 0; i < n - 2; ++i){
            int k = i + 2;
            for(int j = i + 1; j < n; ++j) {
                while(k < n && arr[i] + arr[j] > arr[k]){
                    k++;
                }

                if(k > j){
                    count += k - j - 1;
                }
            }
        }
        return count;


        /*  //Approach with TC: O(N^3)
        for(int i = n-1; i >= 2; --i){
            for(int j = i-1; j>=1; --j){
                for(int k = j-1; k >= 0; --k){
                    int sum = arr[j] + arr[k];
                    if(sum > arr[i]){c
                        count++;
                    }else if(sum < arr[i]){
                        k = -1;
                    }
                }
            }
        } 
         */
    }
}

public class CountTheNumberOfPossibleTriangles{
    public static void main(String[] args){
        int[] arr = {6, 4, 9, 7, 8}; 

        int result = Solution.countTriangles(arr);

        System.out.println("The number of possible triangles is: " + result);
    }
}
