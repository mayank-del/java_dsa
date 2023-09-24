public class MoveAllx {
    public static void main(String[] args) {
        String s="jxbvbdjxxjhuubx";
        move(s,0,0,"");
    }
    public static void move(String str, int idx,int count,String newString){
        if(idx==str.length()){
            for(int i=0;i<count;i++){
                newString+='x';
            }
            System.out.println(newString);
            return;
        }
        char currChar=str.charAt(idx);

        if(currChar=='x'){
            count++;
            move(str,idx+1,count,newString);
        }
        else{
            newString+=currChar;
            move(str,idx+1,count,newString);
        }
    }
}
