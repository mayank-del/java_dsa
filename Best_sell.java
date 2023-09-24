/* class Call{
  

    int sum(int num){
        int n=num,s=0;

        if(n>5){
            
            return 0;
        }
        return (n+sum(n+1));
    }
}
public class Try {
    public static void main (String args[]){
        int n=0;
        Call obj=new Call();
        int res=obj.sum(n);
        System.out.println("Sum is:"+res);
    }


}
 */
/*

class Call{
  

    int sum(int num){
        int n=num,s=0;

        if(n>5){
            
            return 1;
        }
        return (n*sum(n+1));
    }
}
public class Try {
    public static void main (String args[]){
        int n=1;
        Call obj=new Call();
        int res=obj.sum(n);
        System.out.println("Fact is:"+res);
    }


}
 */
/* class Call{
  

    int fact(int num){
        int n=num,s=0;

        if(n==0||n==1){
            
            return 1;
        }
        return (n*fact(n-1));
    }
}
public class Try {
    public static void main (String args[]){
        int n=5;
        Call obj=new Call();
        int res=obj.fact(n);
        System.out.println("Fact is:"+res);
    }


} */
/* public class Try {

    public static void main(String args[]){
        int a=0,b=1;
        System.out.println(a);
        System.out.println(b);
        int n=7;
        fibo(a,b,n);
    }
    public static void fibo(int a,int b,int n){
        if(n==0){
            return;
        } 
    int c=a+b;
    System.out.println(c);
    fibo(b,c,n-1);
    }
}
 *//* 
public class Try {

    public static void main(String args[]){
        int a=2;

        System.out.println(a);
        //System.out.println(b);
        int n=7;
        System.out.println(calcPow(a,n));
    }
    public static int calcPow(int a,int n){
        if(n==0){
            return 1;
        } 
        if(a==0){
            return 0;
        }
    
    //System.out.println(c);
    return a*calcPow(a,n-1);
    }
}
 */
class Best_sell{
    public static void main(String[] args) {
        /* for(int i=1;i<6;i++){
            for(int k=5;k>i;k--){
                System.out.print(" ");
            }
            for(int j=1;j<i;j++){
                System.out.print(0);
            }
            System.out.println();
        } */
        int prices[]={2,4,1};
        int min=prices[0],max=0,currDiff=0,diff=0;
        int minIndex=0;
       
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<min){
                min=prices[i];
                minIndex=i;
                max=min;

            }
                for(int maxIndex=minIndex+1;maxIndex<prices.length;maxIndex++){
                    
                    if(max<prices[maxIndex]){
                        max=prices[maxIndex];
                        
                    }
                    }
                    currDiff=max-min;   
                    if(currDiff>diff){
                        diff=currDiff;
                    }   
        }
        
        
        if(max<min){
            System.out.println("impossible "+0);;
        }
        //diff=max-min;
        System.out.println(diff);;
    }
}

//optimal soln

/* 
 * 
 * int min=prices[0],max=0,currDiff=0,diff=0;
        int size=prices.length;
        for(int i=0;i<size;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            else if(prices[i]-min>diff){
                diff=prices[i]-min;
            }
        }
        return diff;
 */