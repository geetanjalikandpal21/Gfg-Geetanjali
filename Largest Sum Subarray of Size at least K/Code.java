//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public long maxSumWithK(long a[], long n, long k) {
        long prefixSum[] = new long[(int) n];
        prefixSum[0] = a[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        long maxSum = prefixSum[(int) (k - 1)];

        long minPrefixSum = 0;

        for (int i = (int) k; i < n; i++) {
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i - (int) k]);

            // Calculate the sum of the subarray with at least k elements
            long currentSum = prefixSum[i] - minPrefixSum;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
