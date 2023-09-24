public class Try {
    public static void main(String[] args) {
        int prices[]={2,1,2,3,0,1,0,2,3,1,0,1};
        //int prices[]={1,2,3,4,5};
        //int prices[]={2,1,2,0,1};

        int min=prices[0],sum=0,diff=0,tempSum=0;
        int size=prices.length;
        for(int i=0;i<size;i++){
            if(min>prices[i]){
                min=prices[i];
                System.out.println("if "+"i= "+i+","+sum+","+diff+" "+prices[i]+" "+min);

                diff=0;
            }
            // suden decrement after increment
            else if(prices[i]-min<diff){
                if(i>=1){
                    diff=prices[i]-min;
                    //sum=tempSum;
                    //sum=sum+diff;
                    System.out.println("else if "+"i= "+i+","+sum+","+diff+" "+prices[i]+" "+min);
                    //diff=0;
                    tempSum=0;
                    min=prices[i];
                }
            }
            //increasing order,temporary sum
            else if(prices[i]-min>diff){
                if(i==size-1){
                    diff=prices[i]-min;
                    sum=sum+diff;
                    //sum=tempSum+diff;
                    
                    System.out.println("else else if"+"i= "+i+","+sum+","+diff+" "+prices[i]+" "+min);
                        }
                else{
                    diff=prices[i]-min;
                    sum=sum+diff;
                    System.out.println("else else else"+"i= "+i+","+sum+","+diff+" "+prices[i]+" "+min);

                }
                    //min=prices[i];
            }
        }
        
        System.out.println(sum);
    }
}
