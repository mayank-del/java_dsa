import java.util.HashSet;

/* public class SubSeq_of_String {
//subsequence abc means if any char in abc wants to come in our String, they have to follow seq abc , s.t.  c and b can never come before a.
    public static void main(String[] args) {
        String str="abc";
        subseq(str, 0, "");
    }
    public static void subseq(String str,int idx,String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char currChar=str.charAt(idx);

        //criteria for it to be inside str
        subseq(str, idx + 1, newString + currChar);

        //criteria for them to not being inside str
        subseq(str, idx+1, newString);

    }
    
} */

/* They are Unique subsequences */

public class SubSeq_of_String {
//subsequence abc means if any char in abc wants to come in our String, they have to follow seq abc , s.t.  c and b can never come before a.
    public static void main(String[] args) {
        String str="aaa";
        HashSet<String> set=new HashSet<>();
        subseq(str, 0, "",set);
    }
    public static void subseq(String str,int idx,String newString,HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newString)){
            return;
        }
        else{
            System.out.println(newString);
            set.add(newString);
            return;
        }
    }
       
        char currChar=str.charAt(idx);

        //criteria for it to be inside str
        subseq(str, idx + 1, newString + currChar,set);

        //criteria for them to not being inside str
        subseq(str, idx+1, newString,set);

    }
    
}
