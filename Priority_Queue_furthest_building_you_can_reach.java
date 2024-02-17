class Solution {
    public int furthestBuilding(int[] heights, int bricks, int lad) {
        int n=heights.length;
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((x,y)->y-x);
        for(i=0;i<n-1;i++){
            if(heights[i+1]<=heights[i]){continue;}
            int d=heights[i+1]-heights[i];

            if(bricks>=d){
                bricks=bricks-d;
                pq.add(d);
            }else if(lad>0){
                int x=0;
                if(!pq.isEmpty())
                    x=pq.peek();
                if(x>=d){
                    bricks+=x;
                    if(!pq.isEmpty())
                        pq.remove();
                    bricks-=d;
                    pq.add(d);
                }
                lad--;
            }else break;
        }
        return i;
    }
}

// 2 minutes writen code , passed 61/77 test cases.

/*  for(int i=0;i<n-1;i++){
            if(heights[i+1]<=heights[i]){
                count++;
            }else if(heights[i+1]>heights[i]){
                if(bricks>=(heights[i+1]-heights[i])){
                    bricks=bricks-(heights[i+1]-heights[i]);
                    count++;
                }else if(ladders>0){
                    ladders--;
                    count++;
                }else{
                    return count;
                }
            }
        }
        return count; */

        /* 
        //recursion that doesnot worked


        int index=0;
       
       return f(heights, bricks, ladders,n,0);
    }
    int f(int heights[],int bricks, int ladders,int n,int i ){
        if(ladders==0 && bricks==0 && i+1<n && heights[i+1]>heights[i]){
            return 1;
        }
    int constant=0,byladder=0,bybrick=0;
        if(ladders==0 && bricks==0 && i+1<n && heights[i+1]<=heights[i]){
            constant = 1+f(heights, bricks, ladders,n,i+1);
        }
        if(heights[i+1]>heights[i] && ladders>0){
            byladder=1+f(heights, bricks, ladders-1,n,i+1);
        }if(heights[i+1]>heights[i] && bricks>0){
            bybrick=1+f(heights, bricks-(heights[i+1]-heights[i]), ladders,n,i+1);
        }
        return Math.max(i+constant+bybrick,i+constant+byladder);
        
         */