import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion_Amazon__maxm_median_of_subseq_of_size_k {
    
    static int maxMedian = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int ind=0;
        int nums[]={29,34,15,18,9};
        int k=3;
        //maxm suseq sum with
        List<Integer> current=new ArrayList<>();
        f(nums,ind,current,k);
        System.out.println(maxMedian);
    }

    private static void f(int[] arr, int index, List<Integer> current, int k) {
        // Base case: if current subsequence has size k
        if (current.size() == k) {
            List<Integer> temp = new ArrayList<>(current);
            Collections.sort(temp);
            int median = temp.get((k - 1) / 2); // use lower middle for even k
            maxMedian = Math.max(maxMedian, median);
            return;
        }

        // If we reach the end or current size > k
        if (index == arr.length || current.size() > k) {
            return;
        }

        // Pick the current element
        current.add(arr[index]);
        f(arr, index + 1, current, k);

        // Backtrack - remove last element and explore not-pick
        current.remove(current.size() - 1);
        f(arr, index + 1, current, k);
    }
}


