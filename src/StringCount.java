import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCount
{
    public static void main(String[] args)
    {
        BiFunction<String, String[], Integer>  myFunction = (letter, arr) -> {
            int counter = 0;
            for(int i=0;i<arr.length;i++)
                if(arr[i].equals(letter))
                    counter++;
            return counter;
        };
       String myString = "abcdababcdababcdddda";
        System.out.println(Stream.of(myString.split("")).distinct().collect(Collectors.toMap(b -> b, b -> myFunction.apply(b, myString.split("")))));;
    }
}