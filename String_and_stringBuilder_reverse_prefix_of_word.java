class Solution {
    public String reversePrefix(String word, char ch) {
        String find=""+ch;
        int ind=word.indexOf(ch);

        StringBuilder sb=new StringBuilder(word.substring(0,ind+1));

        sb.reverse();

        String rev=sb.toString();
        String res=rev+word.substring(ind+1);

        return res;

    }
}