// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

class HelloWorld {
    public static void main(String[] args) {
        String date="19-06-1995";
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        LocalDate dob=LocalDate.parse(date,format);
        LocalDate curr=LocalDate.now();
        long diff=ChronoUnit.YEARS.between(dob,curr);
        
        System.out.println(diff);
        
    }
}