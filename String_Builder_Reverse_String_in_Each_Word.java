class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(int i=0;i<arr.length;i++){
            sb=new StringBuilder(arr[i]);
            sb.reverse();
            arr[i]=sb.toString();
            sb2.append(arr[i]+" ");
        }

        s=sb2.toString();

        return s.substring(0,s.length()-1);


    }
}