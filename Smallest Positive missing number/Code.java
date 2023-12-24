//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            // Check if the current element is positive and within the range [1, size]
            while (arr[i] >= 1 && arr[i] <= size && arr[arr[i] - 1] != arr[i]) {
                // Swap the current element with the one at its correct position
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Find the first position where the element is not at its correct position
        for (int i = 0; i < size; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all elements are in their correct positions, the missing number is size + 1
        return size + 1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends
