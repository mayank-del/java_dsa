import java.util.*;
public class Count_no_of_Subset {
    public static void main(String[] args) {
        int nums[]={1,2,2,3};
        int n=nums.length;
        int target=3;
        int count=0;
        System.out.println(f(n-1,nums,target));
    }
    public static int f(int n,int []nums,int target){

        if(target==0){
            return 1;
        } 
        if(n==0){
            if(nums[n]==target)
                return 1;
            else
                return 0;
            
        }

        int pick=0;
        int notPick=f(n-1,nums,target);
        
        if(nums[n]<=target){
            pick=f(n-1,nums,target-nums[n]);
        }
        return pick+notPick;
    }
}
