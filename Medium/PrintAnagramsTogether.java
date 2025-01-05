import java.util.*;

class SolutionM1{
public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    
        HashMap<String, ArrayList<String>> ans = new HashMap<>();
        
        for(String str: arr){
            char [] ch = str.toCharArray(); // Convert string to character array
            Arrays.sort(ch); // Sort the characters to form the key
            String word = new String(ch); // Create a sorted string
            
            if(!ans.containsKey(word)){
                ans.put(word, new ArrayList<>()); // Create a new list for a new anagram group
            }
            
            ans.get(word).add(str); // Add the original string to the anagram group
        }
        
        for(ArrayList<String> list : ans.values()){
            result.add(list); // Add each group of anagrams to the result
        }
        
        return result; // Return the list of anagram groups
    }
}

public class PrintAnagramsTogether{
    public static void main(String[] args){
        SolutionM1 solution = new SolutionM1();
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        
        ArrayList<ArrayList<String>> result = solution.anagrams(arr);
        
        for (ArrayList<String> group : result) {
            System.out.println(group);
        }
    }
}
