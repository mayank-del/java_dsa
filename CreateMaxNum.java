public class CreateMaxNum {
    public static void main(String[] args) {
        int nums1[] = {3,4,6,5}, nums2 []= {9,1,2,5,8,3}, k = 5;
        int m=nums1.length;
        int n=nums2.length;
          for(int i=0;i<m-1;i++){
              for(int j=0;j<m-i-1;j++){
                  if(nums1[j]<nums1[j+1]){
                      int temp=nums1[j];
                      nums1[j]=nums1[j+1];
                      nums1[j+1]=temp;
                  }
              }
          }
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(nums2[j]<nums2[j+1]){
                        int temp=nums2[j];
                        nums2[j]=nums2[j+1];
                        nums2[j+1]=temp;
                    }
                }
          }
        int merged[]=new int[k];
        for(int i=0;i<k;i++){
            merged[i]=0;
        }
        int idx1=0;
        int idx2=0;
        int x=0;

          for(int i=0;i<k;i++){
              if(nums1[idx1]>nums2[idx2]){
                  merged[x++]=nums1[idx1++];
              }else{
                  merged[x++]=nums2[idx2++];

              }

          }
        for(int i=0;i<merged.length;i++){
            System.out.println(merged[i]);
          }
    

    }
}
