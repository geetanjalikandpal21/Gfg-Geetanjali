//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    static String[] winner(String arr[], int n) {
        // Your code here
        Map<String, Integer> votes = new HashMap<>();

        // Count votes for each candidate
        for (String candidate : arr) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        // Find the winner (handle lexicographically smaller in case of a tie)
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String candidate = entry.getKey();
            int count = entry.getValue();

            if (count > maxVotes || (count == maxVotes && candidate.compareTo(winner) < 0)) {
                winner = candidate;
                maxVotes = count;
            }
        }

        // Return the result
        return new String[]{winner, Integer.toString(maxVotes)};
    }
}
