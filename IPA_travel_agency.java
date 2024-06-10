import java.util.*;
class IPA_travel_agency{
    
    public static void main(String args[]){

    }


}
class Travel{
    private int regNo;
    private String agencyName;
    private String pacType;
    private int price;
    private boolean fightFacility;

    

    public Travel(int regNo, String agencyName, String pacType, int price, boolean fightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.pacType = pacType;
        this.price = price;
        this.fightFacility = fightFacility;
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

    public void setRegNo(String regNo){
        this.regNo=regNo;
    }

    public void setAgenName(String name){
        this.agencyName=name;
    }
    public void setPacType(String pac){
        this.pacType=pac;
    }
    public void setPrice(String price){
        this.price=price;
    }

    public void setFlightFacility(boolean flightFacility){
        this.flightFacility=flightFacility;
    }


}

