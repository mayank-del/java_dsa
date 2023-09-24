  
      
       StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<=sb.length()-x.length();i++){
           
                /*if(s.charAt(i)==x.charAt(0)){
                
                    String conc=s.substring(i,i+x.length());
                    if(conc.equals(x)){
                         
                        return i;
                    }*/         
                    
        if (sb.charAt(i) == x.charAt(0)) {
            StringBuilder conc = new StringBuilder();
            for (int j = i; j < i + x.length(); j++) {
                conc.append(sb.charAt(j));
            }
            if (conc.toString().equals(x)) {
                return i;
            }
        
    }
                    
                }
            
        
        return -1;