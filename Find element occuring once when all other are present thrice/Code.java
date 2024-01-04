//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int singleElement(int[] arr , int N) {
        int ones = 0;
        int twos = 0;
        
        for (int i = 0; i < N; i++) {
            // Update twos with common set bits of arr[i] and ones
            twos = twos | (ones & arr[i]);

            // Update ones with XOR of arr[i] and ones
            ones = ones ^ arr[i];

            // The common bits are those bits which appear third time
            int commonBitMask = ~(ones & twos);

            // Remove common bits from ones and twos
            ones = ones & commonBitMask;
            twos = twos & commonBitMask;
        }

        return ones;
    }
}
