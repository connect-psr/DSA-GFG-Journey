class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int res[] = new int[arr.length];
        
        if (arr == null || arr.length < 1) {
            return res;
        }
        
        int product = 1, zero = 0;
        
        // Calculate the total product and count zeros
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != 0) {
                product = arr[i] * product;
            } else {
                zero++;
            }
            
            // If there are two or more zeros, all products will be zero
            if (zero >= 2) {
                return res;
            }
        }
        
        // If there is exactly one zero
        if (zero == 1) {
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == 0) {
                    res[i] = product;
                    return res;
                }
            }
        }
        
        // If there are no zeros, calculate the product for each index
        for (int i = 0; i < arr.length; ++i) {
            res[i] = product / arr[i];
        }
        
        return res;
    }
}

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(arr1);
        System.out.println("Result: " + java.util.Arrays.toString(result1)); // Output: [24, 12, 8, 6]

        int[] arr2 = {0, 1, 2, 3};
        int[] result2 = solution.productExceptSelf(arr2);
        System.out.println("Result: " + java.util.Arrays.toString(result2)); // Output: [6, 0, 0, 0]

        int[] arr3 = {0, 0, 1};
        int[] result3 = solution.productExceptSelf(arr3);
        System.out.println("Result: " + java.util.Arrays.toString(result3)); // Output: [0, 0, 0]
    }
}
