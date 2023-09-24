 class Solution{
    public static long conquer(long arr [],int start,int mid, int end){
        long merged[]=new long[end-start+1];
        long count=0;
        int idx1=start;
        int idx2=mid+1;
        int x=0;

        while(idx1<=mid && idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            }
            else{
                merged[x++]=arr[idx2++];
                count= count+(mid+1-idx1);
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=end){
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=start;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }
        return count;

    }
    public static long divide(long arr [],int start, int end){
      long count=0;
       if(start<end){
        
       
       int mid =start+(end - start)/2;

       count+=divide(arr, start, mid);
       count+=divide(arr,mid+1,end);

       count+=conquer(arr,start,mid,end);
    }
    return count;
    }
    

        
    
    static long inversionCount(long arr[], long N)
    {
        int n=arr.length;         
        return divide(arr,0,n-1);
    }
}