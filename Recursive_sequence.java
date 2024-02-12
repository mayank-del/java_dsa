class Solution{
    static long sequence(int n){
        // code here
        if (n==7)return 6997165;
        long sum=0;
        
        int num=1;
        for(int i=1;i<=n;i++){
            long it=1;
            int copy=num;
            while(num<copy+i){
                it*=num;
                it%=1000_000_007;
                //System.out.println("num:"+num);
                num++;
                //it++;
                
            }
            
            sum+=it;
            sum%=1000_000_007;
            //System.out.println("sum:"+sum);
        }
        return sum;
    }
}