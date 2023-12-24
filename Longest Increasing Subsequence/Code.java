//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution {
    // Function to find length of the longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        int[] tailTable = new int[size];
        int len = 1; // Length of LIS
        tailTable[0] = a[0];

        for (int i = 1; i < size; i++) {
            if (a[i] < tailTable[0]) {
                // New smallest value
                tailTable[0] = a[i];
            } else if (a[i] > tailTable[len - 1]) {
                // A[i] extends the current LIS
                tailTable[len++] = a[i];
            } else {
                // A[i] will become a useful candidate to replace a
                // previously identified element in the LIS
                int pos = Arrays.binarySearch(tailTable, 0, len, a[i]);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                tailTable[pos] = a[i];
            }
        }

        return len;
    }
}
