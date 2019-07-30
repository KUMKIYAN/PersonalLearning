import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s){
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = null;
        try{
            date = parseFormat.parse(s);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return displayFormat.format(date);
    }

    public static void main(String[] args) throws IOException {
        String result = timeConversion("07:05:45AM");
        System.out.println(result);
    }
}
