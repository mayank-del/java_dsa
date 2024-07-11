public class CyclicSort {
    public static void main(String[] args) {
        //int arr[]={5,2,1,4,6,3};
        //int arr[]={3,4,2,5,6,1,8,7,10,9};
        int arr[]={2,0,1,0,2,1,0,2,1};

        int i=0;
        while(i<arr.length){/* cyclic sort means numbers should be continuos order from 1 to n and we will just do 1 round traversal by always remembering formula that correct index should be arr[i]-1 (i.e. for number 8 ,it should be 7th index , for number 9 ,it should be 8th index)*/
            int correct=arr[i]-1;
            if(i!=correct){
                swap(arr,i,correct);
            }else{
                i++; //once checking finished ,then only do i++
            }
            
        }
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    static void swap(int arr [],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;    
    }
}

class Marvel{
    int id;
    String name;
    double budget;
    double boxOffice;
    int rating;

    public Marvel(int id, String name, double budget, double boxOffice, int rating) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.boxOffice = boxOffice;
        this.rating = rating;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return this.budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBoxOffice() {
        return this.boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}

public static  double avg(ArrayList<Marvel> arr,double budg){
    int res=0.0;
    int sum=0;
    int cnt=0;
    for(Marvel m:arr){
        if(m.getBudget()>budg){
            sum+=m.getRating
            cnt++;
        }
    }
    if(sum>0){
        res=(double)sum/cnt;
    }
    return res;
} 

public static ArrayList<Marvel> search(ArrayList<Marvel> arr,double box){
    ArrayList<Marvel> res = new ArrayList<>();
        
        for (Marvel m : mr) {
            if (m.getBoxOffice() < box) {
                res.add(m);
            }
        }

        if (res.size() > 0) {
            
            Collections.sort(res, new Comparator<Marvel>() {
                
                public int compare(Marvel a, Marvel b) {
                   
                    return b.getId() - a.getId();
                }
            });
            
            return res;
        } else {
            return null;
        }
}
