//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char ch : A.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            boolean found = false;
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    result.append(entry.getKey());
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.append("#");
            }
        }

        return result.toString();
    }
}
