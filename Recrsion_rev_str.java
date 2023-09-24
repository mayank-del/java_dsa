public class Recrsion_rev_str {
    public static void main(String args[]){
        String s="abcd";
        int last_index=s.length()-1;
        Recsn ob=new Recsn();
        ob.rev(last_index, s);

    }
}
class Recsn{
    public void rev(int last_index,String s){
        if(last_index<0){
            return;
        }
        System.out.print(s.charAt(last_index));
        rev(last_index-1,s);

    }
}
