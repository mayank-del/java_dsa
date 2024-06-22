//First approach

class Solution {
    public int maxScore(int[] card, int k) {
        int n=card.length;
        int lt=0,rt=n;

        int cnt=0;
        int sum=0;
        int maxSum=0;
        for(int i=0;i<=k;i++){
            int lsum=0,rsum=0;
            for(int j=0;j<k-i;j++){
                if(j==k)break;
                else lsum+=card[j];

            }
            for(int j=rt;j>=n-i;j--){
                if(j==n){rt--; break;}
                else rsum+=card[j];
            }
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}

//second approach (Optimal approach(O(n)))

class Solution {
    public int maxScore(int[] card, int k) {
        int n=card.length;
        int lt=0,rt=n;

        int cnt=0;
        int sum=0;
        int maxSum=0;

        int lsum=0,rsum=0;

        for(int j=0;j<k;j++){
                
                lsum+=card[j];

            }
        maxSum=lsum;
        for(int i=0;i<k;i++){
            
            lsum-=card[k-i-1];
            rsum+=card[n-i-1];
            
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}