class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        if(n==1)return  0;
        
        
        Arrays.sort(arr);
        int diff=arr[n-1]-arr[0];
        int minm;
        int maxm;
        
        for(int i=1;i<n;i++){
            //if(arr[i]-k<0)continue;
            
                maxm=Math.max(arr[i-1]+k,arr[n-1]-k);
            
                minm=Math.min(arr[i]-k,arr[0]+k);
            
            diff=Math.min(diff,maxm-minm);
        }
        
        
        return diff;
    }
}
