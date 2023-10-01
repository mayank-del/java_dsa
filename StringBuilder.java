    StringBuilder sb=new StringBuilder();
        sb.append("hello");
        sb.append("bhai");
        //inserting at ith position
        sb .insert(5," dj ");
        
        sb.reverse();
        System.out.println(sb);
        
        sb.reverse();
        System.out.println(sb);
        
        //replacing substring from 2nd to 5th index by delhi  
        sb.replace(2,5," delhi ");
        System.out.println(sb);
        
        //removing substring from 5 to 9
        sb.delete(5,9);
        System.out.println(sb);

        String mainString = "Hello, world!";
        String subString = "world";
        
        int index = mainString.indexOf(subString);

        // lexicographical order comaprison
        //name is smaller in comparison to names[0] name will come before in lexicographical order
        if(name.compareTo(names[0])<0){
                    names[0]=name;
                }
