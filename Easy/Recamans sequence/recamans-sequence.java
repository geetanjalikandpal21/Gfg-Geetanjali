//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> sequence = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        // Start with 0
        int current = 0;
        sequence.add(current);
        visited.add(current);
        
        // Loop to generate the sequence
        for (int i = 1; i < n; i++) {
            int nextNum = current - i;
            // Check if the next number is positive and not visited before
            if (nextNum >= 0 && !visited.contains(nextNum)) {
                sequence.add(nextNum);
                visited.add(nextNum);
                current = nextNum;
            } else {
                // If the next number is negative or visited before, add i to the current number
                current = current + i;
                sequence.add(current);
                visited.add(current);
            }
        }
        
        return sequence;
    }
}
