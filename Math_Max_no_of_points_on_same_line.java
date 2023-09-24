class Solution {
    public int maxPoints(int[][] points) {
        int count=0;
        int maxpt=0;
        if(points.length==1) return 1;
        for(int i=0;i<points.length-1;i++){
            HashMap<Double,Integer> map=new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                double slope=0;
                if(i!=j){
                    if(points[j][0]-points[i][0]==0){
                        
                        map.put(Double.MAX_VALUE,map.getOrDefault(Double.MAX_VALUE,0)+1); 
                    }
                    else{
                        
                        slope=(double)(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                        if(slope==-0.0) slope=0.0;
                        map.put(slope,map.getOrDefault(slope,0)+1); 
                    }
                    
                }


            }
            
            for(Double it:map.keySet()){
                
                    maxpt=Math.max(maxpt,map.get(it)+1);
                
            }
        }
        
        return maxpt;
    }
}