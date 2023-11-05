//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends



class Pair {
    int f, s;

    Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public int[] topK(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.s == b.s) {
                    return b.f - a.f; // Second sorting criterion: number
                } else {
                    return b.s - a.s; // First sorting criterion: frequency
                }
            }
        );

        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().f;
        }

        return res;
    }
}
