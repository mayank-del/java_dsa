class Play{
    
    public static String meth1(int num){
        String res="Returned integer is:"+num;
        return res;
    }
    public static String meth1(int num,boolean b){
        String res="Returned integer is:"+num+","+"Status is:"+b;
        return res;
    }
}
class HelloWorld {
    public static void main(String[] args) {
        Play p=new Play();
        String stored=p.meth1(6,false);
        System.out.print(stored);
    }
}