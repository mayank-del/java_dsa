import java.util.*;
class IPA_travel_agency{
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Start putting inputs");

        ArrayList<Travel> arr=new ArrayList<>();

        for(int i=0;i<3;i++){
            int no=sc.nextInt();sc.nextLine();
            
            String name=sc.nextLine();
            String pac=sc.nextLine();
            int price=sc.nextInt();sc.nextLine();
            boolean fac=sc.nextBoolean();


            Travel tr=new Travel(no,name,pac,price,fac);

            arr.add(tr);

        }

        Travel tobj=findTrByregNoAndPac(arr,2,"PaC1");

            System.out.println(tobj.getRegNo());
            System.out.println(tobj.getAgencyName());
            System.out.println(tobj.getFlightFacility());
    }

    public static Travel findTrByregNoAndPac(ArrayList<Travel> arr,int reg,String pac){
        for(Travel tr:arr){
            if(tr.getRegNo()==reg && tr.getPacType().equalsIgnoreCase(pac)){
                return tr;
            }
        }
        return new Travel(0,"","",0,false);
    }


}
class Travel{
    private int regNo;
    private String agencyName;
    private String pacType;
    private int price;
    private boolean flightFacility;

    

    public Travel(int regNo, String agencyName, String pacType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.pacType = pacType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo(){
        return this.regNo;

    }
    public String getAgencyName(){
        return this.agencyName;
    }

    public String getPacType(){
        return this.pacType;
    }

    public int getPrice(){
        return this.price;
    }
    public boolean getFlightFacility(){
        return this.flightFacility;
    }

    public void setRegNo(int regNo){
        this.regNo=regNo;
    }

    public void setAgenName(String name){
        this.agencyName=name;
    }
    public void setPacType(String pac){
        this.pacType=pac;
    }
    public void setPrice(int price){
        this.price=price;
    }

    public void setFlightFacility(boolean flightFacility){
        this.flightFacility=flightFacility;
    }


}

