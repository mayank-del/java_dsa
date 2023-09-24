//Merge Two Sorted Array//
public class Striver9 {
    public static void main(String[] args) {
        int a[]=new int[8];
        //int k=0;

        int b[]={3,6,8};
        int c[]={1,2,4,5,7};
        int ind=0;
        int old_j=0;
        boolean is_new_j=true;
        int m=b.length;//3
        int n=c.length;//5
        

        for(int i=0;i<(m<n?m:n);i++){
            boolean checked=false;
            for(int j=(is_new_j?old_j:old_j+1);j<(m>n?m:n);j++){
            if(!checked){
            if(b[i]>c[j]){
                //System.out.println("comparison between "+b[i] +"and "+c[j]);

                a[ind]=c[j];
                old_j=j;
                is_new_j=false;
               // k++;
                ind++;
                if(i==m-1){
                    a[m+n-1]=b[m-1];
                }
            }
            else{
                a[ind]=b[i];
                ind++;
                checked=true;
                
                //System.out.println("val of ind"+ind);
                if(j==n-1){
                    a[m+n-1]=c[n-1];
                }

               // k++;
                }
            }
        }
     
        }
           
        System.out.println("array b is:");
        for(int i=0;i<m;i++){
            b[i]=a[i];
            System.out.print(b[i]+",");
        }
        System.out.println();
        System.out.println("array c is:");

        for(int i=m,j=0;i<m+n;i++){
            c[j]=a[i];
            
            System.out.print(c[j]+",");
            j++;
        }
    }
}
