
public String decodeAtIndex(String s, int k) {

//------------------------first method-----------------------

    /*StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))==true){
                int num=s.charAt(i)-'0';
                String s2=str.toString();
                while(num-1!=0){
                    str.append(s2);
                    num--;
                }
            }else{
                str.append(s.charAt(i));
            }
            
        }
        char ch=str.toString().charAt(k-1);
        return ch+""; */
    long size = 0; // Length of decoded `s`

    for (final char c : s.toCharArray())
      if (Character.isDigit(c))
        size *= c - '0';
      else
        ++size;

    for (int i = s.length() - 1; i >= 0; --i) {
      k %= size;
      if (k == 0 && Character.isAlphabetic(s.charAt(i)))
        return s.substring(i, i + 1);
      if (Character.isDigit(s.charAt(i)))
        size /= s.charAt(i) - '0';
      else
        --size;
    }
    return "";
    }