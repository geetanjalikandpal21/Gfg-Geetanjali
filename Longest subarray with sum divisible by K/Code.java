//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Create a HashMap to store the remainders and their corresponding indices
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        int maxLength = 0;
        int currentSum = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            currentSum += a[i];

            // Calculate the remainder when divided by K
            int currentRemainder = currentSum % k;

            // If the remainder is negative, adjust it to be positive
            if (currentRemainder < 0) {
                currentRemainder += k;
            }

            // If the remainder is 0, update the maxLength directly
            if (currentRemainder == 0) {
                maxLength = i + 1;
            } else {
                // If the remainder is already in the HashMap, update maxLength
                if (remainderMap.containsKey(currentRemainder)) {
                    maxLength = Math.max(maxLength, i - remainderMap.get(currentRemainder));
                }

                // If the remainder is not in the HashMap, add it with the current index
                if (!remainderMap.containsKey(currentRemainder)) {
                    remainderMap.put(currentRemainder, i);
                }
            }
        }

        return maxLength;
    }
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends
