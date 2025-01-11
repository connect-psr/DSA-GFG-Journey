class Solution{
    public int longestUniqueSubstr(String s){
        int[] charIndex = new int[128];
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Update the left pointer to the maximum of the current left and 
            // the next position after the last occurrence of the current character
            left = Math.max(charIndex[currentChar], left);

            // Calculate the length of the current window
            maxLength = Math.max(maxLength, right - left + 1);

            // Update the last seen index of the current character
            charIndex[currentChar] = right + 1;
        }

        return maxLength;
    }
}

public class LongestSubstringDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "abcabcbb";
        
        int result = solution.longestUniqueSubstr(input);
        System.out.println("Length of the longest substring with all distinct characters: " + result);
    }
}
