class Solution {
  public int maxLength(List<String> arr) {
        
    return f(arr,0,"");
  }
  public boolean check(List<String> arr,int ind,String str){
        boolean uniq=true;
        HashSet<Character> h=new HashSet<>();
        for(Character ch:str.toCharArray()){
            if(!h.contains(ch)){
                        h.add(ch);
                    }else{
                        uniq=false;
                        break;
                    }
        }
        System.out.println("check"+":"+str+",");
        if(uniq){
             return true;
        }else{
            return false;
        }
    }
    public int f(List<String> arr,int ind,String s){
        if(ind>=arr.size()){
            return 0;
        }
        //String str=charAt(s);
        int take=0;
         System.out.println("f"+":"+s+",");
        if(check(arr,ind,s+arr.get(ind)))
            take = arr.get(ind).length() + f(arr,ind+1,s+arr.get(ind));
    
        int notTake=f(arr,ind+1,s);
        System.out.println("maxm:"+Math.max(take,notTake));
        return Math.max(take,notTake);
        //String st=f();
    }
}