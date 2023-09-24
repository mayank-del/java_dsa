//Sorting by count sort 

class Striver5{
    public static void main(String[] args) {
        int a[]={2,1,0,0,1,2,0};
        int count0=0,count1=0,count2=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                count0++;
            }
            else if(a[i]==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int i=0;i<count0;i++){
            System.out.print(0+",");
        }for(int i=0;i<count1;i++){
            System.out.print(1+",");
        }for(int i=0;i<count2;i++){
            System.out.print(2+",");
        }
    }
}