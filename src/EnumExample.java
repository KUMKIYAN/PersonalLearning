enum Days
{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    Days(){
        System.out.println("created day");
    }

    public static void main(String[] args){
     Days[] days =  Days.values();
     for(Days day:days){
         System.out.println(day);
     }
    }
}


enum Home
{
    KUMAR(1),SUDHAKAR(2),RAVI(3),RAJESH(4);
    int rating;
    Home(int rating) // one arg constructor
    {
        this.rating = rating;
        System.out.println(this + " Constant Rating is => "+ this.rating);
    }
}

enum Family
{
    Sasi(1 , "kiyandoor"),Lakshmi(2, "Sudha"),Vanaja(4, "Rajesh", "Thashvi"),Chaithu(3, "RAVI", "Deepu");
    int position;
    String husband;
    String daughter;
    Family(int position, String husband) // one arg constructor
    {
        this.husband = husband;
        this.position = position;
        System.out.println(this + " Family Cons => "+ this.husband + " Position " + this.position);
    }
    Family(int position, String husband, String daughter) // two arg constructor
    {
        this.husband = husband;
        this.position = position;
        this.daughter = daughter;
        System.out.println(this + " Family Cons => "+ this.husband + " Position " + this.position + " And Their daughter is " + this.daughter);
    }
}

class Enum3
{
    public static void main(String[] args)
    {
        System.out.println(Home.RAVI);
        Home[] h = Home.values();
        for (Home hh : h)
        {
            System.out.println(hh + " Rating -> " + hh.rating);
        }
        System.out.println(Family.Sasi);
    }
}