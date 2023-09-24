import java.util.Scanner;

public class BackTrack_String_permutn {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        permutation(str, 0, str.length()-1);
    }
    public static void permutation(String str,int left,int right){
        if(left==right){
            System.out.println("Base condition,left is:"+left+" Str is:"+str);
            return;
        }
        for(int i=left;i<=right;i++){
            //step1-> Do
            System.out.println("before swap,val of i is:"+i+" val of left is:"+left+" val of str is:"+str);

            str=swap(str, left, i);
            System.out.println("after swap,val of i is:"+i+" val of left is:"+left+" val of str is:"+str);

            //step2-> Recursion
            permutation(str, left+1, right);
            //step3-> Undo Backtrack
            str=swap(str,left,i);

        }
    }
    public static String swap(String str,int left,int i){
        char t;
        char charA[]=str.toCharArray();
        t=charA[left];
        charA[left]=charA[i];
        charA[i]=t;

        return String.valueOf(charA);
    }
}

