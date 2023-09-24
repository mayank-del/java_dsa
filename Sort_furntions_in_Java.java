int[][] array= {
    {1, 5},
    {13, 1},
    {12, 100},
    {12, 85} 
};
Arrays.sort(array, (a, b) -> (a[0]- b[0])); // for ascending order
Arrays.sort(array, (b, a) -> (b[0]- a[0])); // for descending order


String a[]={"ram","shyam","mohan"};
Arrays.sort(a,(x,y)->y.charAt(0)-x.charAt(0));


String a[]={"ram","shyam","mohan"};
Arrays.sort(a,Collections.reverseOrder());



ArrayList<String> s=new ArrayList<>(Arrays.asList("rn", "kl" ,"bk","ypo", "bk"));
Collections.sort(s,(x,y)->y.compareTo(x));