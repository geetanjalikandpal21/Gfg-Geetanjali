//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    

		    for(int i=0; i<res.size(); i++){
		        ot.print(res.get(i)+" ");
		    }
		    
		    ot.println();
		}
		ot.close();
		
	}
}

// } Driver Code Ends


class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leadersList = new ArrayList<>();
        
        // The rightmost element is always a leader
        int maxRight = arr[n - 1];
        leadersList.add(maxRight);
        
        // Iterate from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is greater than or equal to the maxRight,
            // it is a leader, update maxRight
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                leadersList.add(maxRight);
            }
        }
        
        // Reverse the list to get the leaders in the order of their appearance
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = leadersList.size() - 1; i >= 0; i--) {
            result.add(leadersList.get(i));
        }
        
        return result;
    }
}
