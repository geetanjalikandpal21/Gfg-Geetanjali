//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> indices = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Preprocess the pattern to compute the LPS (Longest Proper Prefix which is also Suffix) array
        int[] lps = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                j = lps[j - 1];
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Search for the pattern in the text using the KMP algorithm
        int i = 0;
        j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                indices.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return indices.isEmpty() ? new ArrayList<>(Arrays.asList(-1)) : indices;
    }
}
