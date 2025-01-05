import java.util.ArrayList;
class Solution1{
    /**
     * Generates a list of FizzBuzz strings for numbers from 1 to n.
     * If a number is divisible by 3, it adds "Fizz".
     * If a number is divisible by 5, it adds "Buzz".
     * If divisible by both 3 and 5, it adds "FizzBuzz".
     * Otherwise, it adds the number as a string.
     */

    public static ArrayList<String> fizzBuzz(int n){
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; ++i){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz"); // Divisible by both 3 and 5.
            }else if (i % 3 == 0){
                result.add("Fizz"); // Divisible by 3 only.
            }else if (i % 5 == 0){
                result.add("Buzz"); // Divisible by 5 only.
            }else
                result.add(Integer.toString(i)); // Not divisible by 3 or 5.
        }
        return result;
    }
}

public class FizzBuzz{
    public static void main(String[] args){
        int n = 15;
        ArrayList<String> output = Solution1.fizzBuzz(n);
        System.out.println(output);
    }
}
