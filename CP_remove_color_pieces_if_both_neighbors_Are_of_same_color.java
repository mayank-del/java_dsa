class Solution {
    public boolean winnerOfGame(String col) {

        boolean alice=true;
        int alice_chances=0,bob_chances=0;
        for(int i=1;i<col.length()-1;i++){
            if(col.charAt(i)=='A' && col.charAt(i-1)=='A' && col.charAt(i+1)=='A'){
                alice_chances++;
                }
            else if(col.charAt(i)=='B' && col.charAt(i-1)=='B' && col.charAt(i+1)=='B'){
                bob_chances++;
                }
            }
    String winner="";
        while(true){
            boolean al=false,bob=false;
            if(alice_chances>0){
                alice_chances--;
                al=true;
            
                
            }
            if(bob_chances>0){
                bob_chances--;
                bob=true;
            
                
            }

            if(al==false){
                winner="bob";
                break;
            }else if(bob==false){
                winner="alice";
                break;
            }
        }        
        if(winner.equals("alice")){
            return true;
        }else{
            return false;
        }
    }
}