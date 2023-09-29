class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {

        int lsum[]=new int[arr.length];
        int rsum[]=new int[arr.length];
        int sum=0;
        int n= arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            lsum[i]=sum;
        }
        
        sum=0;
        
        for(int i=n-1;i>=0;i--){
            sum+=arr[i];
            rsum[i]=sum;
        }

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int sum1 = lsum[i];
                int sum2 = lsum[j] - sum1;
                int sum3 = rsum[j+1];

                if(sum1==sum2 && sum2==sum3){
                    return true;
                } 
            }
        }
        return false;
    }
}