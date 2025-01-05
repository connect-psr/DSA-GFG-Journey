class Solution2 {

    public boolean sentencePalindrome(String s){
        int left = 0, n = s.length();
        int right = n - 1;
        s = s.toLowerCase(); // Convert the string to lowercase
        
        while(left < right){
            // Check if the left character is alphanumeric
            if (Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))){
                // Check if the right character is alphanumeric
                if(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))){
                    // Compare the characters
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                    }else{
                        return false; // Return false if not match alphanumeric
                    }
                }else{
                    right--; // Skip non-alphanumeric character on the right
                }
            }else{
                left++; // Skip non-alphanumeric character on the left
            }
        }
        return true; // All characters matched, it's a palindrome
    }
}

public class PalindromeSentence{
    public static void main(String[] args){
        Solution2 solution = new Solution2();
        String sentence = "A man, a plan, a canal, Panama";
        System.out.println(solution.sentencePalindrome(sentence)); // Output: true
    }
}
