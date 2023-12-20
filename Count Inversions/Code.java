//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Create a temporary array to store the sorted elements
        long[] temp = new long[(int) N];

        // Call the helper function to perform merge sort and count inversions
        return mergeSortAndCount(arr, temp, 0, N - 1);
    }

    // Helper function for merge sort and inversion count
    static long mergeSortAndCount(long[] arr, long[] temp, long left, long right) {
        long count = 0;

        if (left < right) {
            long mid = left + (right - left) / 2;

            // Recursively count inversions in the left and right subarrays
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);

            // Merge the two sorted subarrays and count inversions
            count += merge(arr, temp, left, mid, right);
        }

        return count;
    }

    // Merge function to merge two sorted subarrays and count inversions
    static long merge(long[] arr, long[] temp, long left, long mid, long right) {
        long count = 0;

        long i = left; // Index for the left subarray
        long j = mid + 1; // Index for the right subarray
        long k = left; // Index for the merged array

        while (i <= mid && j <= right) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                // If arr[i] > arr[j], it forms inversions with the remaining elements in the left subarray
                temp[(int) k++] = arr[(int) j++];
                count += mid - i + 1;
            }
        }

        // Copy the remaining elements from the left subarray
        while (i <= mid) {
            temp[(int) k++] = arr[(int) i++];
        }

        // Copy the remaining elements from the right subarray
        while (j <= right) {
            temp[(int) k++] = arr[(int) j++];
        }

        // Copy the merged array back to the original array
        for (i = left; i <= right; i++) {
            arr[(int) i] = temp[(int) i];
        }

        return count;
    }
}
