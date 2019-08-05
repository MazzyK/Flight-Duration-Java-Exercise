import java.util.Scanner;

public class flight {

    public static void main(String[] args) {
        
        int ArrHour; //the arrival hour
        int ArrMinute; //the arrival minutes
        int tFormatHour; //the hour in 12 hour format
        String indicator; //PM or AM
        
                
        System.out.println("Give me the departure time:");
        Scanner stime = new Scanner(System.in);
        String DepTime = stime.nextLine();
        
        String[] time = DepTime.split(":"); //split the string into before:and after
        int DepHours = Integer.parseInt(time[0]); //the before is the hour
        int DepMinutes = Integer.parseInt(time[1]);//the after is the minutes
        
        System.out.printf("Give me the duration time in minutes");
        Scanner dtime = new Scanner(System.in);
        int Duration = dtime.nextInt();

        int DurHours = Duration/60; //this gives the hours contained in the duration time
        int DurMinutes = Duration %60; // this gives us the remaining minutes of the duration time
        
        int minutes = DepMinutes + DurMinutes;
        int hours = DepHours +DurHours;
        
        //check to see if arrival hour is after 11 to reset time
        if (hours>23){
            hours = hours - 24;
        }
        else
        {
            hours=hours;
        }
        
        //check to see if arrival minutes exceed 59, if yes then add extra hour to arrival hour and keep remaining minutes
        if (minutes>59){
            ArrMinute = DepMinutes + DurMinutes - 60;
            ArrHour = hours+1;
        }
        else
        {
            ArrHour = hours;
            ArrMinute = DurMinutes + DepMinutes;
        }
        
        //12 hour format
        //if arrival hour is after 11 then reset time
        if (ArrHour>11){
            tFormatHour = ArrHour - 12;    
        }
        else{
            tFormatHour = ArrHour;
        }
        
        // a check to see if AM or PM should be appended to arrival hour
        if (ArrHour>=0 && ArrHour<=11){
            indicator="AM";
        }
        else
        {
            indicator="PM";
        }
        System.out.printf("The time at destination will be %d:%02d or %d:%02d %s",ArrHour,ArrMinute,tFormatHour,ArrMinute,indicator);
            
        }

}
