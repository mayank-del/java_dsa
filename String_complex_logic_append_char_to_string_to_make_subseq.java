class Solution {
  public int appendCharacters(String s, String t) {
    int i = 0; // t's index

    for (final char c : s.toCharArray()){
        if(i<t.length()){
            if(t.charAt(i)==c)i++;
        }
        
    }
    return t.length()-i;
      
  }
}
