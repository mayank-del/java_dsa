public void rotate(int[] nums, int k) {
 
        int n=nums.length;
        if(n<=k) k=k%n;

        int left=0;
        int right=n-k-1;
        //reverse first n-k element
        for(;left<right;){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        //reverse total k element
        left=n-k;
        right=n-1;
        for(;left<right;){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        //finally reverse main array  , now reverse will rotate it by k time clockwise
        left=0;
        right=n-1;
        for(;left<right;){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    } 