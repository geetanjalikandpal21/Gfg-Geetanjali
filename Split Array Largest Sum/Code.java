//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr, int N, int K) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, N, K, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    static boolean isPossible(int[] arr, int N, int K, int mid) {
        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            currentSum += arr[i];

            if (currentSum > mid) {
                count++;
                currentSum = arr[i];
            }
        }

        count++;  // Last subarray

        return count <= K;
    }
}
