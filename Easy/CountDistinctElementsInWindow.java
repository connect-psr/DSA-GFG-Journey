import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> distinctCounts = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int arrayLength = arr.length;

        // Count frequencies of elements in the first window
        for (int index = 0; index < k; index++) {
            frequencyMap.put(arr[index], frequencyMap.getOrDefault(arr[index], 0) + 1);
        }
        distinctCounts.add(frequencyMap.size());

        // Slide the window over the array
        for (int index = k; index < arrayLength; index++) {
            // Remove the element that goes out of the window
            int elementToRemove = arr[index - k];
            if (frequencyMap.get(elementToRemove) > 1) {
                frequencyMap.put(elementToRemove, frequencyMap.get(elementToRemove) - 1);
            } else {
                frequencyMap.remove(elementToRemove);
            }

            // Add the new element in the window
            frequencyMap.put(arr[index], frequencyMap.getOrDefault(arr[index], 0) + 1);

            // Add the size of the current distinct element set to the result
            distinctCounts.add(frequencyMap.size());
        }

        return distinctCounts;
    }
}

public class CountDistinctElementsInWindow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        ArrayList<Integer> result = solution.countDistinct(arr, k);

        // Print the result
        System.out.println("Distinct elements in each window of size " + k + ": " + result);
    }
}
