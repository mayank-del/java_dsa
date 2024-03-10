class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] nums, int n)
    { 
        // Your code here
        
        long nge[] = new long[n];
        Stack < Long > st = new Stack < > ();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()<=nums[i]) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek()>nums[i]){
                nge[i]=st.peek();
                
            }else{
                nge[i]=-1;
            }
            st.push(nums[i]);
        }
        
        return nge;
    } 
}