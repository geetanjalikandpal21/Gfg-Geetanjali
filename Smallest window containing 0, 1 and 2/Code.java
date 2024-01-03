//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int n = S.length();

        // Initialize variables to store the count of each character
        int[] count = new int[3];

        // Initialize variables to represent the left and right pointers of the window
        int left = 0, right = 0;

        // Initialize the length of the smallest substring
        int minLength = Integer.MAX_VALUE;

        while (right < n) {
            // Update the count for the current character
            count[S.charAt(right) - '0']++;

            // Try to minimize the window by moving the left pointer
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Update the minimum length if a smaller substring is found
                minLength = Math.min(minLength, right - left + 1);

                // Decrease the count of the character at the left pointer
                count[S.charAt(left) - '0']--;

                // Move the left pointer to the right
                left++;
            }

            // Move the right pointer to the right
            right++;
        }

        // Check if a valid substring was found
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
