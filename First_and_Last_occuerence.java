public class First_and_Last_occuerence {
    public static void main(String args[]){
        String s= "ahjjbjbsadf";
        Flo_Check obj=new Flo_Check();
        obj.check(s,0,'j');
        //System.out.println(s.indexOf('a'));
    }
}
class Flo_Check{
    public static int first=-1;
    public static int last=-1;
    public void check(String str,int idx,char element){
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar=str.charAt(idx);
        if(currChar==element){
            if(first==-1){
                first=idx;
            }
            else{
                last=idx;
            }
        }
        check(str,idx+1,element);
    }
}
