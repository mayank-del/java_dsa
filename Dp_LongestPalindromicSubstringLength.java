static int longestPalin(String s){
        // code here
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String rev=sb.toString();
        int n=s.length();
        return f(s,rev,n-1,n-1,0);
    }
    static int f(String s,String t,int ind,int ind2,int count){
        if(ind<0 || ind2<0){
            return count;
        }
        int same=count;
        
        if(s.charAt(ind)==t.charAt(ind2)){
            same=1+f(s,t,ind-1,ind2-1,count+1);
            
        }
        
        return Math.max(same,Math.max(f(s,t,ind-1,ind2,0),f(s,t,ind,ind2-1,0)));
        
    }