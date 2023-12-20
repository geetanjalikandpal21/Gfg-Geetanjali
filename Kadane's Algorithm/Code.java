//{ Driver Code Starts
import java.io.*;

import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution {
    
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {
        long maxEndingHere = arr[0];
        long maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            // Calculate the maximum subarray sum ending at the current position
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update the overall maximum subarray sum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
